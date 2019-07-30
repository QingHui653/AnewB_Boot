package com.newb.stream.server;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author qinghui
 * @Description: TODO
 * @date 2019/7/30 15:55
 */
public interface Sink {

    String INPUT = "input";

    @Input(Sink.INPUT)
    SubscribableChannel input();

}
