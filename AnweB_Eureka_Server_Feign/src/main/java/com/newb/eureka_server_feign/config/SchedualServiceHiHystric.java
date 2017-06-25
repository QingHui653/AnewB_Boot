package com.newb.eureka_server_feign.config;

import org.springframework.stereotype.Component;

import com.newb.eureka_server_feign.service.SchedualServiceHi;

/**
 * feign 断路器配置
 * @author woshizbh
 *
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
	
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

	@Override
	public Integer add(Integer a, Integer b) {
		return -999;
	}
}
