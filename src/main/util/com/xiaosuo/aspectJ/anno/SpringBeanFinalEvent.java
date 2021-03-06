package com.xiaosuo.aspectJ.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 最终都会执行的事件
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SpringBeanFinalEvent {
	String service();
	String method();
	String paramRule() default "";
}
