package com.xiaosuo.aspectJ.impl;

import java.lang.annotation.Annotation;

import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;
import com.xiaosuo.aspectJ.impl.base.AbstractControllerEventImpl;
import com.xiaosuo.aspectJ.interfaces.AnnoBeforeEventInterface;

/**
 * 默认的处理事前的实现方式
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public class DefaultBeforeEventImpl extends AbstractControllerEventImpl implements AnnoBeforeEventInterface{

	@Override
	public Object dealAnnoEvent(Annotation annotation, Object... inParams){
		SpringBeanBeforeEven beforeEvent = annoToBefore(annotation);
		String service = beforeEvent.service();
		String method = beforeEvent.method();
		String paramRule = beforeEvent.paramRule();
		return dealEvent(service, method, paramRule, inParams);
	}

	@Override
	public SpringBeanBeforeEven annoToBefore(Annotation annotation) {
		return (SpringBeanBeforeEven) annotation;
	}
}
