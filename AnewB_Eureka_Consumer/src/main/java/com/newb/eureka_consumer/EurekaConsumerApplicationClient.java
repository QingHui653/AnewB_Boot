package com.newb.eureka_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 普通 消费者 ,不使用 feign 注解形式.
 * 从 LoadBalancerClient loadBalancerClient 中 自己选择 实例.
 * 通过 restTemplate 调用 URL .
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerApplicationClient {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClientApplicationClient.class, args);
		new SpringApplicationBuilder(EurekaConsumerApplicationClient.class).web(true).run(args);
	}
	
	
}
