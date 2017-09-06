package com.xiaosuo.aspectJ.factory;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;
import com.xiaosuo.aspectJ.impl.DefaultAfterEventImpl;
import com.xiaosuo.aspectJ.impl.DefaultBeforeEventImpl;
import com.xiaosuo.aspectJ.interfaces.AnnoAfterEventInterface;
import com.xiaosuo.aspectJ.interfaces.AnnoBeforeEventInterface;
import com.xiaosuo.aspectJ.util.SpringAopUtil;
import com.xiaosuo.exceptions.EventException;

/**
 * controller事件处理
 * 
 * @author suozhaoyu
 * @version 0.1
 */
@Aspect
@Component
public class ControllerEventFactory {
	
	private static final AnnoBeforeEventInterface beforeEventImpl = new DefaultBeforeEventImpl();
	private static final AnnoAfterEventInterface afterEventImpl = new DefaultAfterEventImpl();

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
					return e.result;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 事中
		 */
		boolean hasEx = false;
		try {
			returnObj = joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
			hasEx = true;
		}
		
		/*
		 * 事后
		 */
		boolean judAfter = SpringAopUtil.judResultHasAnnotation(SpringBeanAfterEven.class, result);
		if(!hasEx && judAfter){
			SpringBeanAfterEven afterEvent = SpringAopUtil.getAnnotationInMethod(joinPoint, SpringBeanAfterEven.class);
			try{
				afterEventImpl.dealAnnoEvent(afterEvent, args);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 异常处理
		 */
		if(hasEx){
			
		}
		
		return returnObj;
	}
}
