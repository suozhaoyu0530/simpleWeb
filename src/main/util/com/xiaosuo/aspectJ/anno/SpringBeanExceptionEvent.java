package com.xiaosuo.aspectJ.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 异常事件注解
 * 
 * @author suozhaoyu
 * @version 0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SpringBeanExceptionEvent {
	String service();
	String method();
	String paramRule() default "";
}
