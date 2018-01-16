package com.newb.eureka_server_ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * HystrixCommand 会自动为函数实现 依赖隔离
     *
     * 断路器 当达到某种 状态时，断路器 将打开。
     * 打开后 直接调用回调函数。
     */
    @HystrixCommand(fallbackMethod = "fallback")//发生断路是回调方法
    public String consumer() {
        return restTemplate.getForObject("http://pangdo-client/dc",String.class);
    }
    public String fallback() {
        return "fallback";
    }

    @HystrixCommand(fallbackMethod = "hiError")//发生断路是回调方法
    public String hiService(String name) {
        return restTemplate.getForObject("http://pangdo-client/hi?name="+name,String.class);
    }
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
