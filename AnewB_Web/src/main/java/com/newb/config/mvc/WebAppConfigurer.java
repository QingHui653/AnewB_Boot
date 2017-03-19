package com.newb.config.mvc;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.newb.component.handlerInterceptor.MyInterceptor1;
import com.newb.component.handlerInterceptor.MyInterceptor2;

/**
 * 
 * @author woshizbh
 *
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        
//        其中 addResourceLocations 的参数是动参，可以这样写
//        registry.addResourceLocations("classpath:/img1/", "classpath:/img2/", "classpath:/img3/");
        
//        如果我们要指定一个绝对路径的文件夹（如 D:/data/api_files ），则只需要使用 addResourceLocations 指定即可。
//        可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上file:
//        registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/data/api_files");
        super.addResourceHandlers(registry);
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
 
}
