package com.newb.stream.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author qinghui
 * @Description: TODO
 * @date 2019/7/30 19:00
 */
@EnableBinding(Source.class)
public class SinkSender {

    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timerMessageSource() {
        //
        return () -> {
            logger.info("发送消息--");
            return new GenericMessage<>("{\"name\":\"didi\", \"age\":30}");
        };
    }

}
