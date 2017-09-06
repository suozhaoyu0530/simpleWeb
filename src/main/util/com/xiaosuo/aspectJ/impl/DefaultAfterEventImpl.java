package com.xiaosuo.aspectJ.impl;

import java.lang.annotation.Annotation;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.aspectJ.impl.base.AbstractEventImpl;
import com.xiaosuo.aspectJ.interfaces.AnnoAfterEventInterface;

/**
 * 默认的处理事后的实现方式
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public class DefaultAfterEventImpl extends AbstractEventImpl implements AnnoAfterEventInterface{

	@Override
	public Object dealAnnoEvent(Annotation annotation, Object... inParams) {
		SpringBeanAfterEven afterEvent = annoToBefore(annotation);
		String service = afterEvent.service();
		String method = afterEvent.method();
		return dealEvent(service, method, inParams);
	}

	@Override
	public SpringBeanAfterEven annoToBefore(Annotation annotation) {
		return (SpringBeanAfterEven) annotation;
	}
}