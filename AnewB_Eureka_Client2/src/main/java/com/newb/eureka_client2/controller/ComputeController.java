/**
 * @author woshizbh
 *
 */
package com.newb.eureka_client2.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
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
	public String dc() {
		String services = "Services: " + client.getServices();
		System.out.println(services);
		return "2--- "+services;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance instance = client.getLocalServiceInstance();
		Integer r = a + b;
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		return r;
	}
	
    @RequestMapping("/hi")
	@SentinelResource(fallback = "restHomeFallback" )
    public String home(@RequestParam String name) throws DegradeException  {
		if(true) throw new DegradeException("123");
        return "2--- "+"hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/hi/{name}")
    public String restHome(@PathVariable String name) {
        return "2--- "+"hi "+name+",i am from port:" +port;
    }

    //wiki https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
	public String restHomeFallback(String name) {
		logger.info(name);
		return "error";
	}
}