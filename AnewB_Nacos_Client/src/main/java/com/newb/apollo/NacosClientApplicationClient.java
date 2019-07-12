package com.newb.apollo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientApplicationClient {

	public static void main(String[] args) {
		new SpringApplicationBuilder(NacosClientApplicationClient.class).web(true).run(args);
	}

}
