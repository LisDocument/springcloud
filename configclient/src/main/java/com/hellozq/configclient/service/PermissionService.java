package com.hellozq.configclient.service;

import com.hellozq.common.vo.MenuVo;
import com.hellozq.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/18
 * time: 9:08
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "user")
public interface PermissionService {

    @GetMapping("permission/getRolePermission/{roleId}")
    Result<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}
