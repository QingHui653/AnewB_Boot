package com.newb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//其实：@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication
//查找servlet 和 filter
//@ServletComponentScan
@MapperScan(basePackages = "com.newb.mybatis.db.dao")
//注解 打开异步，未测试是否可忽视
@EnableAsync
//extends SpringBootServletInitializer 使tomcat能使用spring boot 项目
//@EntityScan(basePackages="com.newb.hibernate")  
//@EnableJpaRepositories(basePackages="com.newb.hibernate") 
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * 使用fastjson替代springboot 默认json
	 * 会使得 返回字符串 自动带上引号
	 * @return
	 */
	/*@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}*/

	//tomcat 使用 War 包 //extends SpringBootServletInitializer
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
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
