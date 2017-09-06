package com.xiaosuo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop的配置
 * 
 * @author suozhaoyu
 * @since  2017-08-29 11:58:50
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	public static final String base = test();
	
	public static final String test(){
		return "execution(java.lang.String com.xiaosuo..*.controller.*.*(..))";
	}
}
