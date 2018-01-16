package com.newb.eureka_server_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.newb.eureka_server_ribbon.service.HelloService;

@RestController
public class HelloControler {
	
	@Autowired
    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;
    
    
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://SERVICE-HI/add?a=10&b=20", String.class).getBody();
    }

    @GetMapping("/consumer")
    public String dc() {
        return restTemplate.getForObject("http://pangdo-client/dc", String.class);
    }

    @RequestMapping(value = "/consumer2")
    public String consumer2(){
        return helloService.consumer();
    }
}