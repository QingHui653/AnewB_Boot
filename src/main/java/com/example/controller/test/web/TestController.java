package com.example.controller.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.test.entity.User;
import com.example.controller.test.service.UserService;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 测试spring boot 运行 返回json
	 * @return
	 */
	@RequestMapping("list")
	public Object list() {
		User u=  userService.getUserById(1);
		return u;
	}
	
	/**
	 * 测试捕获全局异常
	 * @return
	 */
	@RequestMapping("/zeroException")
    public int zeroException(){
       return 100/0;
    }
}
