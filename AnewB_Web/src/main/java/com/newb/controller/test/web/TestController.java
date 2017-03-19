package com.newb.controller.test.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newb.common.util.SpringUtil;
import com.newb.mybatis.db.entity.User;
import com.newb.mybatis.db.service.UserService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	// 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hello:Hello Angel}")
    private String hello;
	
	/**
	 * 测试spring boot 运行 返回json
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public Object list() {
		User u=  userService.getUserById(1);
		return u;
	}
	
	/**
	 * 测试捕获全局异常
	 * @return
	 */
	@RequestMapping("/zeroException")
	@ResponseBody
    public int zeroException(){
       return 100/0;
    }
	
	/**
	 * 测试spring boot 运行 返回json
	 * @return
	 */
	@RequestMapping("springUtil")
	@ResponseBody
	public Object springUtil() {
		UserService uService= (UserService) SpringUtil.getBean("DataSource");
		User u=  uService.getUserById(1);
		return u;
	}
	
	/**
	 * 测试从配置文件读取参数
	 * @param map
	 * @return
	 */
	@RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello", hello);
        return "helloJsp";
    }
}
