package com.newb.starter_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:woshizbh
 * @Date: 2018/12/12
 * @Deseription
 * https://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/#boot-features-bean-conditions
 */

/**
 * 1.Spring Boot在启动时扫描项目所依赖的JAR包，寻找包含spring.factories文件的JAR包
 * 2.根据spring.factories配置加载AutoConfigure类
 * 3.根据 @Conditional注解的条件，进行自动配置并将Bean注入Spring Context
 */
@Configuration
@ConditionalOnClass(ExampleService.class)//当classpath下发现该类的情况下进行自动配置。
@EnableConfigurationProperties(ExampleServiceProperties.class)
public class ExampleAutoConfigure {

    @Autowired
    private ExampleServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean //当Spring Context中不存在该Bean时。
    @ConditionalOnProperty(prefix = "example.service",value = "enabled",havingValue = "true") //当配置文件中example.service.enabled=true时
    ExampleService exampleService (){
        return  new ExampleService(properties.getPrefix(),properties.getSuffix());
    }

}
