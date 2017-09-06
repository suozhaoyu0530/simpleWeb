package com.xiaosuo.aspectJ.interfaces;

import com.xiaosuo.aspectJ.anno.SpringBeanExceptionEvent;

/**
 * 异常事件的处理接口
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public interface ExceptionEventInterface{

	/**
	 * 处理异常
	 * 
	 * @param event
	 * @param e
	 * @param returnType
	 * @param inParams
	 * @return
	 */
	Object dealException(SpringBeanExceptionEvent event, Exception e, String returnType, Object[] inParams);
}
