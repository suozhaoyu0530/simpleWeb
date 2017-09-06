package com.xiaosuo.aspectJ.interfaces;

import com.xiaosuo.exceptions.base.SuoException;

/**
 * 事件接口
 * 
 * @author suozhaoyu
 * @version 0.1
 */
public interface EventInterface {

	/**
	 * 处理事件
	 * 
	 * @param service
	 * @param method
	 * @param params
	 * @return
	 */
	Object dealEvent(String service, String method, Object...params);
	
	/**
	 * 处理返回值
	 * 
	 * @param e
	 * @param returnType
	 * @return
	 */
	Object dealReturnValue(Exception e, String returnType, Object[] params);
	
	/**
	 * 处理suoException
	 * 
	 * @param e
	 * @param resultType
	 * @param inParams
	 */
	default void dealSuoException(SuoException e, String returnType, Object[] inParams){
		
	}
}
