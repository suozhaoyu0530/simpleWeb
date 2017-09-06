package com.xiaosuo.aspectJ.interfaces;

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
}
