package com.newb.eureka_server_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//feign是自带断路器的 ,配置关闭 :feign.hystrix.enabled=false 
public class ApplicationClientFeign {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClientFeign.class, args);
	}
	
}
