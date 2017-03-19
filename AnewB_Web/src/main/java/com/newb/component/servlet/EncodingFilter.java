package com.newb.component.servlet;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * UTF-8编码拦截器
 * @author woshizbh
 *
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
         @WebInitParam(name="encoding",value="UTF-8"),//
         @WebInitParam(name="forceEncoding",value="true")//
 }
)
public class EncodingFilter extends CharacterEncodingFilter {
	
}
