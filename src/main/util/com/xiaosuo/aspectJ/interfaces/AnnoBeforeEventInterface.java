package com.xiaosuo.aspectJ.interfaces;

import java.lang.annotation.Annotation;

import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;

/**
 * 事前事件接口
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
public interface AnnoBeforeEventInterface extends AnnoEventInterface{

	/**
	 * 获得准确的事前事件的注解内容
	 * 
	 * @param annotation
	 * @return
	 */
	SpringBeanBeforeEven annoToBefore(Annotation annotation);
}
