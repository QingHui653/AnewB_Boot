package com.newb.eureka_server_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  
@EnableHystrix  //开启断路器 修改service
@EnableHystrixDashboard //开启仪表盘
/**
 * ribbon提供 客户端 负载均衡 功能
 * ribbon 不具备  熔断 的作用.需要手动 引入 Hystrix
 */
public class ApplicationClientRibbon {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClientRibbon.class, args);
	}
	
	@Bean
    @LoadBalanced //此处标示 负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
