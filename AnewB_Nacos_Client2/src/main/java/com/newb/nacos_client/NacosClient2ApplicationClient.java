package com.newb.nacos_client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosClient2ApplicationClient {

	public static void main(String[] args) {
		new SpringApplicationBuilder(NacosClient2ApplicationClient.class).web(true).run(args);
	}

}
