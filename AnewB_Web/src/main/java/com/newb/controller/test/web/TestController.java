package com.newb.controller.test.web;

import java.util.Map;

import com.newb.starter_log.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private ExampleService exampleService;

	// 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hello:Hello Angel}")
    private String hello;

	/**
	 * 测试捕获全局异常
	 * @return
	 */
    @GetMapping("/zeroException")
	@ResponseBody
    public int zeroException(){
       return 100/0;
    }
	
	/**
	 * 测试从配置文件读取参数
	 * @param map
	 * @return
	 */
    @GetMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello", hello);
        return "helloJsp";
    }

	/**
	 * 测试自定义 starter
	 * @param word
	 * @return
	 */
	@GetMapping("/input")
	@ResponseBody
	public String input(String word){
		return exampleService.wrap(word);
	}
}
