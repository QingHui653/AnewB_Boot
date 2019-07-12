package com.newb.apollo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosClient2ApplicationClient {

	public static void main(String[] args) {
		new SpringApplicationBuilder(NacosClient2ApplicationClient.class).web(true).run(args);
	}

}
