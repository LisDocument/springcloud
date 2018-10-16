package com.hellozq.configclient.service.impl;

import com.hellozq.common.vo.Result;
import com.hellozq.common.vo.UserVo;
import com.hellozq.configclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/18
 * time: 8:40
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public Result<UserVo> findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        return Result.failure(100,"调用失败",new UserVo());
    }
}
