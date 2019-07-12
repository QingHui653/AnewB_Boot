package com.newb.apollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Service2Controller {
    private final Logger logger = LoggerFactory.getLogger(Service2Controller.class);

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @GetMapping("/test2")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        String result = restTemplate.getForObject("http://pangdo-nacos-client/hi?name=didi", String.class);
        return "restTemplate中注入@LoadBalanced \n" +
                "Return : " + result;
    }

}