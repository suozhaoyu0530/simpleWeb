package com.xiaosuo.aspectJ.interfaces;

import java.lang.annotation.Annotation;

/**
 * 通过注解来标记事件的接口
 * 
 * @author suozhaoyu
 * @since  1.0
 */
public interface AnnoEventInterface extends EventInterface{

	/**
	 * 将注解事件转换为一般事件
	 * 
	 * @param annotation
	 * @param inParams：事件主体方法的入参
	 * @return
	 */
	Object dealAnnoEvent(Annotation annotation, Object...inParams);
}
