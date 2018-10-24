package com.hellozq.miya.dao;

import com.hellozq.common.vo.UserVo;

import java.util.List;

public interface UserDao {
    int insert(UserVo userVo);

    List<UserVo> selectUsers();
}
