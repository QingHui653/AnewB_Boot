package com.newb.nacos_client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class Service1Controller {

    private final Logger logger = LoggerFactory.getLogger(Service1Controller.class);

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("pangdo-nacos-client");
//        String url = serviceInstance.getUri() + "/hi?name=" + "didi";
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hi?name=didid";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "loadBalancerClient + RestTemplate \n " +
                "Invoke : " + url + ", return : " + result;
    }

}