package com.newb.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qinghui
 * @Description: TODO
 * @date 2019/7/12 10:33
 */
@Configuration
@EnableApolloConfig
public class ApolloConfig {
    @Bean
    public TestJavaConfigBean javaConfigBean() {
        return new TestJavaConfigBean();
    }
}
