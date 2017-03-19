package com.newb.controller.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newb.mybatis.db.service.UserService;

@RestController
@RequestMapping("/db")
public class DbTestController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 添加事务
	 * @param id
	 * @return
	 */
	@GetMapping("/dbexcWithTr/{id}")
	public Object dbExcWithTr(@PathVariable("id") Integer id ) {
		Boolean success =  userService.testWithTr(id);
		return success;
	}
	
	/**
	 * 没有添加事务
	 * @param id
	 * @return
	 */
	@GetMapping("/dbexcNoTr/{id}")
	public Object dbExcNoTr(@PathVariable("id") Integer id ) {
		Boolean success =  userService.testNoTr(id);
		return success;
	}
}
