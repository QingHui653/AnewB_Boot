package com.newb.component.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogProxy {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Pointcut("execution(* com.newb.controller..*Controller.*(..))")
	private void Log() {}

	@Before("Log()")
	public void beforeAdvice(JoinPoint point) throws ClassNotFoundException {
		System.out.println("");
		System.out.println("");
		System.out.println("-------------------------------日志代理开始--------------------------------------------------");
		System.out.println("----------------进入的方法为 --- "+point.toString());
		System.out.println("----------------传入的参数为---" +Arrays.toString(point.getArgs()));
		String curtime=sdf.format(Calendar.getInstance().getTime());
	 	System.out.println("----------------开始时间---"+curtime);
	}

	@After("Log()")
	public void afterAdvice() {
		String curtime=sdf.format(Calendar.getInstance().getTime());
		System.out.println("----------------结束时间---"+curtime);
		System.out.println("-------------------------------日志代理结束--------------------------------------------------");
	}

	@SuppressWarnings("rawtypes")
	@AfterReturning(pointcut = "Log()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		if (retVal!=null) {
			if(retVal instanceof List){
				System.out.println("----------------返回List的个数为--"+((List)retVal).size());
			}else {
				System.out.println("----------------返回值为--" + retVal.toString());
			}
		}
	}

	@AfterThrowing(pointcut = "Log()", throwing = "ex")
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}
}
