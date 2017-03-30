package com.newb.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newb.common.util.ResultUtil;

/**
 * 异常全局处理类
 * 
 * @author woshizbh
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
	
	@ExceptionHandler
	@ResponseBody
	public Object defaultErrorHandler(HttpServletRequest req, Exception e) {
		// // If the exception is annotated with @ResponseStatus rethrow it and
		// let
		// // the framework handle it - like the OrderNotFoundException example
		// // at the start of this post.
		// // AnnotationUtils is a Spring Framework utility class.
		// if (AnnotationUtils.findAnnotation(e.getClass(),
		// ResponseStatus.class) != null)
		// throw e;
		//
		// // Otherwise setup and send the user to a default error-view.
		// ModelAndView mav = new ModelAndView();
		// mav.addObject("exception", e);
		// mav.addObject("url", req.getRequestURL());
		// mav.setViewName(DEFAULT_ERROR_VIEW);
		// return mav;
		
		System.out.println("---------进入全局异常处理-------GlobalDefaultExceptionHandler.defaultErrorHandler()");
		ResultUtil res = new ResultUtil();
		
		res.setSuccessful(false);
		res.setResultmessage(e.getMessage());
		
		logger.warn("--全局捕获类捕获异常  ", e);
		
		return res;
		// 打印异常信息：
//		System.out.println("---------进入全局异常处理-------GlobalDefaultExceptionHandler.defaultErrorHandler()");

		/*
		 * 返回json数据或者String数据： 那么需要在方法上加上注解：@ResponseBody 添加return即可。
		 */

		/*
		 * 返回视图： 定义一个ModelAndView即可， 然后return;
		 * 定义视图文件(比如：error.html,error.ftl,error.jsp);
		 *
		 */
	}
}
