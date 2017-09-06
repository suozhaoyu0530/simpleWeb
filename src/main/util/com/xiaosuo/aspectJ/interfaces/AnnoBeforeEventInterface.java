package com.xiaosuo.aspectJ.interfaces;

import java.lang.annotation.Annotation;

import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;

/**
 * 事前事件接口
 * 
 * @author suozhaoyu
 * @since  1.0
 */
public interface AnnoBeforeEventInterface extends AnnoEventInterface{

	/**
	 * 获得准确的事前事件的注解内容
	 * 
	 * @param annotation
	 * @return
	 */
	SpringBeanBeforeEven annoToBefore(Annotation annotation);
	
	/**
	 * 事前异常处理
	 * 
	 * @param inParams
	 */
	void dealException(Object...inParams);
}
