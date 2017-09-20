package com.xiaosuo.aspectJ.interfaces;

import java.lang.annotation.Annotation;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;

/**
 * 事后事件接口
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public interface AnnoAfterEventInterface extends AnnoEventInterface{

	/**
	 * 获得准确的事后事件的注解内容
	 * 
	 * @param annotation
	 * @return
	 */
	SpringBeanAfterEven annoToBefore(Annotation annotation);
}
