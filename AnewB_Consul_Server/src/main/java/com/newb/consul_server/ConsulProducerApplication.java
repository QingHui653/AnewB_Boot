package com.newb.consul_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProducerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ConsulProducerApplication.class, args);
//		new SpringApplicationBuilder(ConsulProducerApplication.class).web(true).run(args);
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