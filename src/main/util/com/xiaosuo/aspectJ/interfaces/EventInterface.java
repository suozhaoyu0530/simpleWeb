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
	Object dealEvent(String service, String method, String paramRule, Object...params);
	
	/**
	 * 处理返回值
	 * 
	 * @param e
	 * @param returnType
	 * @return
	 */
	Object dealReturnValue(Exception e, String returnType, Object[] params);
	
	/**
	 * 处理一般的入参
	 * 
	 * @param willParams
	 * @param inParams
	 * @return
	 */
	Object[] dealNormalInParams(Class<?>[] willTypes, Object[] inParams);
	
	/**
	 * 处理suoException
	 * 
	 * @param e
	 * @param resultType
	 * @param inParams
	 */
	default void dealSuoException(SuoException e, String returnType, Object[] inParams){
		e.printStackTrace();
	}
	
	/**
	 * 处理异常
	 * 
	 * @param e
	 * @param inParams
	 */
	default void dealException(Exception e, Object[] inParams){
		e.printStackTrace();
	}
}
