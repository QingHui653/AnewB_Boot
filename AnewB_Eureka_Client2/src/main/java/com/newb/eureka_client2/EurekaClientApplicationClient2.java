package com.newb.eureka_client2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplicationClient2 {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClientApplicationClient.class, args);
		new SpringApplicationBuilder(EurekaClientApplicationClient2.class).web(true).run(args);
	}
	
	
}
