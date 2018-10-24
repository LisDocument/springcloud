package com.hellozq.miya.controller;

import com.hellozq.common.vo.UserVo;
import com.hellozq.miya.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/5
 * time: 16:18
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserDao userDao;

    @GetMapping("/hi")
    public String callHome(){

        return "miya:"+restTemplate.getForObject("http://localhost:8988/provide", String.class);
    }

    @GetMapping("/provide")
    public String provide(){
        return "来自miya的接口";
    }

    @PostMapping("/add")
    public int addUser(@RequestBody UserVo userVo){
        return userDao.insert(userVo);
    }

    @GetMapping()
    public List<UserVo> findAllUser(){
        return userDao.selectUsers();
    }

}
