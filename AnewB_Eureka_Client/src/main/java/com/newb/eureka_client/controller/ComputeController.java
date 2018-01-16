/**
 * @author woshizbh
 *
 */
package com.newb.eureka_client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


@RestController
public class ComputeController {
	
	private final Logger logger = LoggerFactory.getLogger(ComputeController.class);
	
	@Autowired
	private DiscoveryClient client;
	@Value("${server.port}")
    String port;

	@GetMapping("/dc")
	public String dc() throws InterruptedException {
		Thread.sleep(10000L);
		String services = "Services: " + client.getServices();
		System.out.println(services);
		return services;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance instance = client.getLocalServiceInstance();
		Integer r = a + b;
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		return r;
	}
	
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/hi/{name}")
    public String restHome(@PathVariable String name) {
        return "hi "+name+",i am from port:" +port;
    }
}