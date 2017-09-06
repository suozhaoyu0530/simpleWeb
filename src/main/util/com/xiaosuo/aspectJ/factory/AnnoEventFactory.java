package com.xiaosuo.aspectJ.factory;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;

/**
 * 注解事件的处理工厂
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public class AnnoEventFactory {
	
//	@Pointcut("execution(* com.xiaosuo..*.controller.*.*(..)) && @annotation(com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven)")
	@Pointcut("@annotation(com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven)")
	private void before(){}
//	@Pointcut("execution(* com.xiaosuo..*.controller.*.*(..)) && @annotation(com.xiaosuo.aspectJ.anno.SpringBeanAfterEven)")
	@Pointcut("@annotation(com.xiaosuo.aspectJ.anno.SpringBeanAfterEven)")
	private void after(){}
	@Pointcut("execution(* com.xiaosuo..*.controller.*.*(..))")
	private void all(){}
	
	@Before("before() && @annotation(event)")
	public void annoBefore(JoinPoint joinPoint, SpringBeanBeforeEven event){
		System.out.println("=================================This is Before Event=======================");
		
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest) args[0];
		String type = request.getParameter("type");
		System.out.println("事前："+ type);
		request.setAttribute("type", "0003");
		System.out.println(event.service() +"=========="+ event.method());
	}
	
	@AfterReturning(value="after() && @annotation(event)", returning="result")
	public void annoAfter(String result, SpringBeanAfterEven event){
		System.out.println("=================================This is After Event========================");
		System.out.println(result);
		System.out.println(event.service() +"=========="+ event.method());
	}
}
