package com.newb.apollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ComputeController {
	
	private final Logger logger = LoggerFactory.getLogger(ComputeController.class);
	
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi ";
    }

    @RequestMapping("/hi/{name}")
    public String restHome(@PathVariable String name) {
        return "hi "+name;
    }
}