package com.hellozq.configclient.service.impl;

import com.hellozq.common.vo.Result;
import com.hellozq.common.vo.RoleVo;
import com.hellozq.configclient.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/18
 * time: 9:12
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public Result<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败","getRoleByUserId");
        return Result.failure(100,"调用getRoleByUserId失败",new ArrayList<>());
    }
}
