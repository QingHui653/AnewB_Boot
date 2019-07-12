package com.newb.apollo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApolloApplicationClient {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApolloApplicationClient.class).web(true).run(args);
	}

}
