package com.newb.stream.controller;

import com.newb.stream.server.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Service1Controller {

    private final Logger logger = LoggerFactory.getLogger(Service1Controller.class);

    @Autowired
    private SinkSender sinkSender;

    @RequestMapping("test")
    public void test(){
        MessageSource<String> stringMessageSource = sinkSender.timerMessageSource();
        System.out.println("生产者发送消息"+stringMessageSource);
    }

}