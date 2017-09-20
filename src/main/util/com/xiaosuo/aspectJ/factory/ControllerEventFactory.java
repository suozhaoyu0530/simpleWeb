package com.xiaosuo.aspectJ.factory;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;
import com.xiaosuo.aspectJ.anno.SpringBeanExceptionEvent;
import com.xiaosuo.aspectJ.impl.DefaultAfterEventImpl;
import com.xiaosuo.aspectJ.impl.DefaultBeforeEventImpl;
import com.xiaosuo.aspectJ.impl.DefaultExceptionEventImpl;
import com.xiaosuo.aspectJ.interfaces.AnnoAfterEventInterface;
import com.xiaosuo.aspectJ.interfaces.AnnoBeforeEventInterface;
import com.xiaosuo.aspectJ.interfaces.ExceptionEventInterface;
import com.xiaosuo.aspectJ.util.SpringAopUtil;
import com.xiaosuo.exceptions.EventException;
import com.xiaosuo.exceptions.base.SuoException;

/**
 * controller事件处理
 * 
 * @author suozhaoyu
 * @version 0.0.1
 */
@Aspect
@Component
public class ControllerEventFactory {
	
	private static final AnnoBeforeEventInterface beforeEventImpl = new DefaultBeforeEventImpl();
	private static final AnnoAfterEventInterface afterEventImpl = new DefaultAfterEventImpl();
	private static final ExceptionEventInterface exceptionEventImpl = new DefaultExceptionEventImpl();

	/**
	 * controller包下并且没有@ControllerEvent注解,返回值为String的切点
	 */
//	@Pointcut("execution(java.lang.String com.xiaosuo..*.controller.*.*(..))")
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void around(){}
	
	@Around("around()")
	public Object aroundPointcut(ProceedingJoinPoint joinPoint){
		Method method = SpringAopUtil.getMethod(joinPoint);
		String resultType = method.getReturnType().getName();
		return dealPointCut(joinPoint, resultType);
	}
	
	/**
	 * 切点处理的正体
	 * 
	 * @param joinPoint
	 * @return
	 */
	private Object dealPointCut(ProceedingJoinPoint joinPoint, String returnType){
		Object returnObj = null;
		
		Object[] args = joinPoint.getArgs();
		/*
		 * 判断是否有before after注解，如果有的话，进行处理
		 */
		int result = SpringAopUtil.getMethodSpectJAnnotations(joinPoint);
		
		/*
		 * 事前
		 */
		boolean judBefore = SpringAopUtil.judResultHasAnnotation(SpringBeanBeforeEven.class, result);
		if(judBefore){
			SpringBeanBeforeEven beforeEven = SpringAopUtil.getAnnotationInMethod(joinPoint, SpringBeanBeforeEven.class);
			try{
				beforeEventImpl.dealAnnoEvent(beforeEven, args);
			}catch (EventException e) {
				if(!e.iscontinue){
					return beforeEventImpl.dealReturnValue(e, returnType, args);
				}
			}catch (SuoException e) {
				beforeEventImpl.dealSuoException(e, returnType, args);;
			}catch (Exception e) {
				beforeEventImpl.dealException(e, args);
			}
		}
		
		/*
		 * 事中
		 */
		boolean hasEx = false;
		Exception ex = null;
		try {
			returnObj = joinPoint.proceed(args);
		} catch (Throwable e) {
			ex = (Exception) e;
			hasEx = true;
		}
		
		/*
		 * 异常处理
		 */
		if(hasEx){
			SpringBeanExceptionEvent event = null;
			boolean judException = SpringAopUtil.judResultHasAnnotation(SpringBeanExceptionEvent.class, result);
			if(judException){
				event = SpringAopUtil.getAnnotationInMethod(joinPoint, SpringBeanExceptionEvent.class);
			}
			returnObj = exceptionEventImpl.dealException(event, ex, returnType, args);
		}
		
		/*
		 * 事后
		 */
		boolean judAfter = SpringAopUtil.judResultHasAnnotation(SpringBeanAfterEven.class, result);
		if(!hasEx && judAfter){
			SpringBeanAfterEven afterEvent = SpringAopUtil.getAnnotationInMethod(joinPoint, SpringBeanAfterEven.class);
			try{
				afterEventImpl.dealAnnoEvent(afterEvent, args);
			}catch (SuoException e) {
				afterEventImpl.dealSuoException(e, returnType, args);
			}catch (Exception e) {
				afterEventImpl.dealException(e, args);
			}
		}
		
		
		return returnObj;
	}
}
