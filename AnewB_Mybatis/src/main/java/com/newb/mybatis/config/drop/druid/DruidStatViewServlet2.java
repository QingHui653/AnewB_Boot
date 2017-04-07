package com.newb.mybatis.config.drop.druid;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 已注释使用
 * druid servlet 具体看旧项目 web.xml
 * 开启SQL监控
 * 第一种方式 配置
 * 因spring boot 版本 第一种不对需修改，无法监控SQL
 * @author woshizbh
 *
 */
/*@WebServlet(urlPatterns="/druid/*",
	initParams={
	         @WebInitParam(name="allow",value="192.168.1.72,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
	         @WebInitParam(name="deny",value="192.168.1.73"),// IP黑名单 (存在共同时，deny优先于allow)
	         @WebInitParam(name="loginUsername",value="admin"),// 用户名
	         @WebInitParam(name="loginPassword",value="123456"),// 密码
	         @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
	}
)*/
public class DruidStatViewServlet2 extends StatViewServlet {
	private static final long serialVersionUID = 1L;
}
