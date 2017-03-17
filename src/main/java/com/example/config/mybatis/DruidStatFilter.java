package com.example.config.mybatis;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid filter 具体看旧项目 web.xml
 * 过滤器
 * 第一种方式 配置
 * 因spring boot 版本 第一种不对需修改，无法监控SQL
 * @author woshizbh
 *
 */
/*@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
	initParams={
	         @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
	 }
)*/
public class DruidStatFilter extends WebStatFilter{
	 
}
