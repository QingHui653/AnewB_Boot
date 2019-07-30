package com.newb.stream.server;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author qinghui
 * @Description: TODO
 * @date 2019/7/30 19:15
 */
public interface Source {
    String OUTPUT = "input";

    @Output(Source.OUTPUT)
    MessageChannel output();
}
