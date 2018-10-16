package com.hellozq.configclient.service.impl;

import com.hellozq.common.vo.MenuVo;
import com.hellozq.common.vo.Result;
import com.hellozq.common.vo.RoleVo;
import com.hellozq.common.vo.UserVo;
import com.hellozq.configclient.service.PermissionService;
import com.hellozq.configclient.service.RoleService;
import com.hellozq.configclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/18
 * time: 9:17
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    private final int FAILD_CODE = 100;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<UserVo> userResult = userService.findByUsername(username);
        if(FAILD_CODE == userResult.getCode()){
            throw new UsernameNotFoundException("用户" + username + "不存在！");
        }
        //可用性：true可用；false不可用
        boolean enabled = true;
        //过期性：true没过期；false过期
        boolean accountNonExpired = true;
        //有效性：true凭证有效；false：凭证无效
        boolean credentialsNonExpired = true;
        //锁定性：true：未锁定；false：已锁定
        boolean accountNonLocked = true;

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        UserVo userVo = userResult.getData();

        Result<List<RoleVo>> roleResult = roleService.getRoleByUserId(userVo.getId());

        if(FAILD_CODE != roleResult.getCode()){
            List<RoleVo> roleVoList = roleResult.getData();
            roleVoList.forEach(role -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
                grantedAuthorities.add(grantedAuthority);

                //获取权限
                Result<List<MenuVo>> perResult = permissionService.getRolePermission(role.getId());

                if(FAILD_CODE != perResult.getCode()){
                    List<MenuVo> permissionList = perResult.getData();
                    permissionList.forEach(menuVo -> {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menuVo.getCode());
                        grantedAuthorities.add(authority);
                    });
                }
            });
        }
        User user = new User(userVo.getUsername(),userVo.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,grantedAuthorities);
        return user;
    }
}
