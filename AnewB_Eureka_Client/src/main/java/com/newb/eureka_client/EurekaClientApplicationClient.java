package com.newb.eureka_client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplicationClient {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClientApplicationClient.class, args);
		new SpringApplicationBuilder(EurekaClientApplicationClient.class).web(true).run(args);
	}
	
	
}
