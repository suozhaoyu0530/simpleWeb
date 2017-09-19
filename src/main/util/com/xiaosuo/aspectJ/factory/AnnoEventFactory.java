package com.xiaosuo.aspectJ.factory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;
import com.xiaosuo.exceptions.base.SuoException;

/**
 * 注解事件的处理工厂
 * 
 * @author suozhaoyu
 * @since  0.1
 */
@Aspect
@Component
@Order(5)
public class AnnoEventFactory {
	
	@Pointcut("@annotation(com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven) && !@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void before(){}
	@Pointcut("@annotation(com.xiaosuo.aspectJ.anno.SpringBeanAfterEven) && !@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void after(){}
	
	@Before("before() && @annotation(event)")
	public void annoBefore(JoinPoint joinPoint, SpringBeanBeforeEven event){
		System.out.println("=================================This is Before Event=======================");
		throw new SuoException("Test exception rollback status");
	}
	
	@AfterReturning(value="after() && @annotation(event)")
	public void annoAfter(SpringBeanAfterEven event){
		System.out.println("=================================This is After Event========================");
		throw new SuoException("Test exception rollback status");
	}
}
