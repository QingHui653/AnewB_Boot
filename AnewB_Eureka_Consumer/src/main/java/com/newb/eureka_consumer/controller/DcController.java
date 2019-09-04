/**
 * @author woshizbh
 *
 */
package com.newb.eureka_consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class DcController {
	
	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	@Qualifier("myRestTemplate")
	RestTemplate myRestTemplate;

	@GetMapping("/dc")
	public String dc() {
		/**
		 * 普通的 消费者 需要 自己 选择 实例 进行消费
		 */
		ServiceInstance serviceInstance = loadBalancerClient.choose("pangdo-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}

	@GetMapping("/port")
	public String port() {
		String url = "http://pangdo-client/dc";
		System.out.println(url);
		return myRestTemplate.getForObject(url, String.class);
	}

	@GetMapping("/add")
	public String add() {
		/**
		 * 普通的 消费者 需要 自己 选择 实例 进行消费
		 */
		ServiceInstance serviceInstance = loadBalancerClient.choose("pangdo-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/add?a=3&b=6";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
}