package com.hellozq.servicehi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThisLi(Bin)
 * @date 2018/9/5
 * time: 16:03
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome(){
        return "service-hi:"+restTemplate.getForObject("http://localhost:8989/provide", String.class);
    }

    @RequestMapping("/provide")
    public String provide(){
        return "来自service-hi的接口";
    }
}
