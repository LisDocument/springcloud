package com.hellozq.miya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping("/hi")
    public String callHome(){

        return "miya:"+restTemplate.getForObject("http://localhost:8988/provide", String.class);
    }

    @RequestMapping("/provide")
    public String provide(){
        return "来自miya的接口";
    }
}
