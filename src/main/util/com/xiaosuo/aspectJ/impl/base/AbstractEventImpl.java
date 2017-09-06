package com.xiaosuo.aspectJ.impl.base;

import java.lang.reflect.InvocationTargetException;

import com.xiaosuo.aspectJ.interfaces.AnnoEventInterface;
import com.xiaosuo.common.util.ServiceMethodCache;
import com.xiaosuo.common.util.bean.MethodCache;
import com.xiaosuo.exceptions.EventException;

/**
 * 默认的处理方法
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public abstract class AbstractEventImpl implements AnnoEventInterface{

	@Override
	public Object dealEvent(String service, String method, Object... params){
		/*
		 * 获取方法
		 */
		MethodCache cache = ServiceMethodCache.getCache(service, method);
		/*
		 * 调用方法
		 */
		Object obj = cache.getService();
		Object returnVal = null;
		try {
			returnVal = cache.getMethod().invoke(obj, params);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			if(e.getTargetException().getClass().getName().equals("com.xiaosuo.exceptions.EventException")){
				throw (EventException) e.getTargetException();
			}else{
				e.printStackTrace();
			}
		}
		
		return returnVal;
	}
}
