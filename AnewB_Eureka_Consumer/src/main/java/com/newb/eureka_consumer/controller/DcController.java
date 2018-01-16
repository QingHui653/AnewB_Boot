/**
 * @author woshizbh
 *
 */
package com.newb.eureka_consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class DcController {
	
	private final Logger logger = LoggerFactory.getLogger(DcController.class);

	@Autowired
	LoadBalancerClient loadBalancerClient;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/consumer")
	public String dc() {
		/**
		 * 普通的 消费者 需要 自己 选择 实例 进行消费
		 */
		ServiceInstance serviceInstance = loadBalancerClient.choose("pangdo-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
}