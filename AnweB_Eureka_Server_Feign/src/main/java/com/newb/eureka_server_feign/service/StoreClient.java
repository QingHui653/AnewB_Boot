package com.newb.eureka_server_feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.newb.eureka_server_feign.config.FooConfiguration;
//configuation 制定服务类
//@FeignClient(name = "service-hi", configuration = FooConfiguration.class)
public interface StoreClient {

	@RequestMapping(method = RequestMethod.GET,value = "/hi2")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
