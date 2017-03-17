package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//其实：@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication
//查找servlet 和 filter 
@ServletComponentScan
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/**
	 * 使用fastjson替代springboot 默认json
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
	
	/**
     * 注册Servlet.不需要添加注解：@ServletComponentScan
     * 编码有问题
     * @return
     */
    /*@Bean
    public ServletRegistrationBean MyServlet1(){
        return new ServletRegistrationBean(new com.example.component.servlet.MyServlet1(),"/myServlet1/*");
    }*/
}
