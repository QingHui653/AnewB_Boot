package com.newb.apollo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Service3Controller {
    private final Logger logger = LoggerFactory.getLogger(Service3Controller.class);

//    spring-boot2.0 , spring5.0才有
//    @Bean
//    @LoadBalanced
//    public WebClient.Builder loadBalancedWebClientBuilder() {
//        return WebClient.builder();
//    }


//    @Autowired
//    private WebClient.Builder webClientBuilder;

//    @GetMapping("/test3")
//    public Mono<String> test() {
//        Mono<String> result = webClientBuilder.build()
//                .get()
//                .uri("http://pangdo-nacos-client/hi?name=didi")
//                .retrieve()
//                .bodyToMono(String.class);
//        return result;
//    }

}