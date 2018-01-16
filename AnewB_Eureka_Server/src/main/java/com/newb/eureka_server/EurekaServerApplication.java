package com.newb.eureka_server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
	}
}
/**
 * 服务发现比较 https://luyiisme.github.io/2017/04/22/spring-cloud-service-discovery-products/?utm_source=tuicool&utm_medium=referral
 * Euraka Consul 各有 使用场景
 *
 * Consul 的 注册中心 与 zookeeper 一样 ，需要
 * 下载 服务端 程序 运行 ，提供者 直接 注册即可。
 * 提供者查看 Eureka_Client 的配置
 */