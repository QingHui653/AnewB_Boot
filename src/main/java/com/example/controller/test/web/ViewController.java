package com.example.controller.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/view")
public class ViewController {
	
	/**
	  *  返回中文字符串,需要在MVC中配置 不然会自动加引号
	  * @param modelMap
	  * @param userId
	  * @return
	  */
	 @RequestMapping(value="/string",method= RequestMethod.GET) //,produces ="text/html;charset=UTF-8" 返回UTF-格式
	 @ResponseBody
	 public String showUserByString(){
	        String str="hello word 你好世界";
	        return str;
	 	}
	
	/**
	 * restful风格
	 * @return
	 */
	@RequestMapping(value="/say1/{id}",method= RequestMethod.GET)
	@ResponseBody
	public Object say1(@PathVariable("id") Integer id) {
		return "id: "+id;
	}
	
	/**
	 * SOAP风格
	 * @return
	 */
//	@RequestMapping(value="/say2",method= RequestMethod.GET)
	@GetMapping(value="/say2")
	@ResponseBody
	public Object say2(@RequestParam(value="id",required=false,defaultValue="0") Integer id) {
		return "id: "+id;
	}
}
