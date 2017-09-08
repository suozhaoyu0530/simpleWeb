package com.xiaosuo.aspectJ.impl;

import java.lang.annotation.Annotation;

import com.xiaosuo.aspectJ.anno.SpringBeanExceptionEvent;
import com.xiaosuo.aspectJ.impl.base.AbstractControllerEventImpl;
import com.xiaosuo.aspectJ.interfaces.ExceptionEventInterface;

/**
 * 默认的controller处理异常的实现方式
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public class DefaultControllerExceptionEventImpl extends AbstractControllerEventImpl implements ExceptionEventInterface{

	@Override
	public Object dealAnnoEvent(Annotation annotation, Object... inParams) {
		SpringBeanExceptionEvent event = (SpringBeanExceptionEvent) annotation;
		String service = event.service();
		String method = event.method();
		String paramRule = event.paramRule();
		super.dealEvent(service, method, paramRule, inParams);
		return null;
	}

	@Override
	public Object dealException(SpringBeanExceptionEvent event, Exception e, String returnType, Object[] inParams) {
		if(null != event){
			dealAnnoEvent(event, inParams);
		}
		return super.dealReturnValue(e, returnType, inParams);
	}
}
