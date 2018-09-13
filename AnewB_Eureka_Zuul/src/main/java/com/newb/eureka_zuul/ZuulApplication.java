package com.newb.eureka_zuul;

import com.newb.eureka_zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
/**
 * zuul网关 提供 负载均衡 动态路由 反向代理、权限认证等等
 */
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
		System.out.println("success");
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
