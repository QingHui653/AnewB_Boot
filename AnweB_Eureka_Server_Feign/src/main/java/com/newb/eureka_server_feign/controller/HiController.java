/**
 * @author woshizbh
 *
 */
package com.newb.eureka_server_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newb.eureka_server_feign.service.SchedualServiceHi;

@RestController
public class HiController {

	@Autowired
	SchedualServiceHi schedualServiceHi;

	@RequestMapping(value = "/hi",method =RequestMethod.GET)
	public String sayHi(@RequestParam String name) {
		System.out.println("--"+name);
		return schedualServiceHi.sayHiFromClientOne(name);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return schedualServiceHi.add(10, 20);
    }
}