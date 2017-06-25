/**
 * @author woshizbh
 *
 */
package com.newb.eureka_server_feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * 制定服务配置类
 * 重写配置，需要加@Configuration注解，并重写下面的两个bean
 * @author woshizbh
 *
 */
//@Configuration
public class FooConfiguration {
    /*@Bean
    //此配置会与 Hystrix冲突 导致获取不到 http menthod 报错
    public Contract feignContractg() {
        return new feign.Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
    
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    @Bean
    public SchedualServiceHiHystric fb(){
        return new SchedualServiceHiHystric();
    }*/

}