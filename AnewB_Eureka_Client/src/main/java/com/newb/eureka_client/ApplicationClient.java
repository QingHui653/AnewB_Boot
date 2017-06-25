package com.newb.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationClient {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClient.class, args);
	}
	
	
}
