package com.hellozq.configclient.service.impl;

import com.hellozq.common.vo.MenuVo;
import com.hellozq.common.vo.Result;
import com.hellozq.configclient.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/18
 * time: 9:15
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Override
    public Result<List<MenuVo>> getRolePermission(Integer roleId) {
        log.info("调用{}失败","getRolePermission");
        return Result.failure(100,"调用getRolePermission失败",new ArrayList<>());
    }
}
