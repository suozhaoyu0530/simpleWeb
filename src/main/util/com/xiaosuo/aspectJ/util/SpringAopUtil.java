package com.xiaosuo.aspectJ.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * aop工具
 * 
 * @author suozhaoyu
 * @version 0.1
 */
public class SpringAopUtil {

	/**
	 * 获取切点的方法拥有的自定义的aop注解
	 * 
	 * @param joinPoint
	 * @return
	 */
	public static int getMethodSpectJAnnotations(JoinPoint joinPoint){
		Method method = getMethod(joinPoint);
		return getMethodSpectJAnnotations(method);
	}

	/**
	 * 获取切点的方法拥有的自定义的aop注解
	 * 
	 * @param method
	 * @return
	 */
	public static int getMethodSpectJAnnotations(Method method){
		int result = 0;
		
		Annotation[] annotations = AnnotationUtils.getAnnotations(method);
		for(Annotation annotation : annotations){
			String simpleName = annotation.annotationType().getSimpleName();
			int type = AnnoTypeContant.getAnnoType(simpleName);
			result = result | type;
		}
		
		return result;
	}
	
	/**
	 * 获取调用方法
	 * 
	 * @param joinPoint
	 * @return
	 */
	public static Method getMethod(JoinPoint joinPoint){
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		return methodSignature.getMethod();
	}
	
	/**
	 * 根据方法拥有的自定义的注解的返回结果，判断是否拥有某个注解
	 * 
	 * @param annotation
	 * @param result
	 * @return
	 */
	public static boolean judResultHasAnnotation(Class<? extends Annotation> annotation, int result){
		String simpleName = annotation.getSimpleName();
		int type = AnnoTypeContant.getAnnoType(simpleName);
		
		return (result & type) > 0;
	}
	
	/**
	 * 获取方法上的注解对象
	 * 
	 * @param joinPoint
	 * @param annotationType
	 * @return
	 */
	public static <A extends Annotation> A getAnnotationInMethod(JoinPoint joinPoint, Class<A> annotationType){
		Method method = getMethod(joinPoint);
		return getAnnotationInMethod(method, annotationType);
	}
	
	/**
	 * 获取方法上的注解对象
	 * 
	 * @param method
	 * @param annotationType
	 * @return
	 */
	public static <A extends Annotation> A getAnnotationInMethod(Method method, Class<A> annotationType){
		return AnnotationUtils.getAnnotation(method, annotationType);
	}
}
