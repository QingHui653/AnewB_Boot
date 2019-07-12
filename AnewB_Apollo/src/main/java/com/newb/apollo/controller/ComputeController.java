package com.newb.apollo.controller;

import com.newb.apollo.config.TestJavaConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ComputeController {
	
	private final Logger logger = LoggerFactory.getLogger(ComputeController.class);

	@Autowired
	private TestJavaConfigBean testJavaConfigBean;

    @RequestMapping("/hi")
    public String home() {
        return testJavaConfigBean.toString();
    }

}