package com.xiaosuo.aspectJ.factory;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;
import com.xiaosuo.aspectJ.impl.DefaultAfterEventImpl;
import com.xiaosuo.aspectJ.impl.DefaultBeforeEventImpl;
import com.xiaosuo.aspectJ.interfaces.AnnoAfterEventInterface;
import com.xiaosuo.aspectJ.interfaces.AnnoBeforeEventInterface;
import com.xiaosuo.aspectJ.util.SpringAopUtil;
import com.xiaosuo.exceptions.EventException;
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
	
	private static final AnnoBeforeEventInterface beforeEventImpl = new DefaultBeforeEventImpl();
	private static final AnnoAfterEventInterface afterEventImpl = new DefaultAfterEventImpl();
	
	@Pointcut("@annotation(com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven) && !@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void before(){}
	@Pointcut("@annotation(com.xiaosuo.aspectJ.anno.SpringBeanAfterEven) && !@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void after(){}
	
	/**
	 * 事前事件
	 * 
	 * @param joinPoint
	 * @param event
	 */
	@Before("before() && @annotation(event)")
	public void annoBefore(JoinPoint joinPoint, SpringBeanBeforeEven event){
		Method method = SpringAopUtil.getMethod(joinPoint);
		String returnType = method.getReturnType().getName();
		Object[] args = joinPoint.getArgs();
		
		try{
			beforeEventImpl.dealAnnoEvent(event);
		}catch (EventException e) {
			if(!e.iscontinue){
				throw e;
			}
		}catch (SuoException e) {
			beforeEventImpl.dealSuoException(e, returnType, args);
			throw e;
		}catch (Exception e) {
			beforeEventImpl.dealException(args);
			throw e;
		}
	}
	
	/**
	 * 事后处理
	 * 
	 * @param joinPoint
	 * @param event
	 */
	@AfterReturning(value="after() && @annotation(event)")
	public void annoAfter(JoinPoint joinPoint, SpringBeanAfterEven event){
		Method method = SpringAopUtil.getMethod(joinPoint);
		String returnType = method.getReturnType().getName();
		Object[] args = joinPoint.getArgs();
		
		try{
			afterEventImpl.dealAnnoEvent(event);
		}catch (EventException e) {
			if(!e.iscontinue){
				throw e;
			}
		}catch (SuoException e) {
			afterEventImpl.dealSuoException(e, returnType, args);
			throw e;
		}catch (Exception e) {
			afterEventImpl.dealException(args);
			throw e;
		}
	}
}
