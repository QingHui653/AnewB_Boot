package com.newb.starter_log;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther:woshizbh
 * @Date: 2018/12/12
 * @Deseription
 */
@ConfigurationProperties("example.service")
@Data
public class ExampleServiceProperties {
    private String prefix;
    private String suffix;
}
