package com.hellozq.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * 关于RefreshScope申明了一个类，其中的参数会根据actuator/bus-refresh(Post)访问触发修改
 * 只会修改RefreshScope申明的地方
 * @author ThisLi(Bin)
 * @date 2018/9/5
 * time: 11:10
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${foo}")
    private String foo;

    @GetMapping
    public String get(){
        return foo;
    }
}
