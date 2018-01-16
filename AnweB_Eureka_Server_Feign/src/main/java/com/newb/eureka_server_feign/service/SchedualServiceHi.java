/**
 * @author woshizbh
 *
 */
package com.newb.eureka_server_feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.newb.eureka_server_feign.config.SchedualServiceHiHystric;

import feign.RequestLine;

@FeignClient(value ="pangdo-client",fallback=SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @GetMapping(value = "/dc")
    String consumer();

	@GetMapping(value = "/hi")
    /*@RequestLine("GET /hi/name={name}")*/
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
    
    @GetMapping(value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
    
}