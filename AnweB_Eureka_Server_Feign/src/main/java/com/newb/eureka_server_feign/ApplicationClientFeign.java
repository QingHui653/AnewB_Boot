package com.newb.eureka_server_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是基于Ribbon实现 , 自带 负载 也支持 通过Ribbon的IRule进行策略扩展
 * Feign  扩展了对Spring MVC注解的支持，同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端
 * 整合的Hystrix来实现服务的容错保护，在Dalston版本中，Feign的Hystrix默认是关闭的
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//feign是自带断路器的 ,配置关闭 :feign.hystrix.enabled=false 
public class ApplicationClientFeign {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClientFeign.class, args);
	}
	
}
