package com.example.component.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 使用@WebListener注解，实现ServletContextListener接口
 *
 * @author woshizbh
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("--------ServletContex监听器初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("--------ServletContex监听器销毁");
	}


}
