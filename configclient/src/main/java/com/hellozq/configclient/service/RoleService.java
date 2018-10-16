package com.hellozq.configclient.service;

import com.hellozq.common.vo.Result;
import com.hellozq.common.vo.RoleVo;
import com.hellozq.configclient.service.impl.RoleServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/18
 * time: 8:55
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "user",fallback = RoleServiceImpl.class)
public interface RoleService {
    /**
     * 获取权限规则
     * @param userId 用户id
     * @return 规则序列
     */
    @GetMapping("role/getRoleByUserId/{userId}")
    Result<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
