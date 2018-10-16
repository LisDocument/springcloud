package com.hellozq.configclient.service;

import com.hellozq.common.vo.Result;
import com.hellozq.common.vo.UserVo;
import com.hellozq.configclient.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/17
 * time: 17:11
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "user",fallback = UserServiceImpl.class)
public interface UserService {

    /**
     * 查询用户
     * @param username 用户名
     * @return 用户实体
     */
    @GetMapping("/user/findByUsername/{username}")
    Result<UserVo> findByUsername(@PathVariable("username") String username);
}
