package com.newb.nacos_client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Service4FeignController {
    private final Logger logger = LoggerFactory.getLogger(Service4FeignController.class);



    @Autowired
    Client client;

    @GetMapping("/test4")
    public String test() {
        String result = client.hello("didi");
        return "使用Feign \n " +
                "Return : " + result;
    }

    @FeignClient("pangdo-nacos-client")
    interface Client {

        @GetMapping("/hi")
        String hello(@RequestParam(name = "name") String name);

    }
}