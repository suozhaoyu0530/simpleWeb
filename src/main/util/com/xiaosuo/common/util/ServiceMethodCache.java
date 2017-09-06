package com.xiaosuo.common.util;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import com.xiaosuo.application.SpringBeanUtil;
import com.xiaosuo.common.util.bean.MethodCache;
import com.xiaosuo.exceptions.UtilException;

/**
 * service的method缓存
 * 
 * @author suozhaoyu
 * @since  1.0
 */
public class ServiceMethodCache {

	private static final ConcurrentMap<String, MethodCache> CACHE = new ConcurrentHashMap<>();
	
	/**
	 * 获取缓存的值
	 * 
	 * @param service
	 * @param method
	 * @return
	 */
	public static MethodCache getCache(String service, String method){
		String key = getKey(service, method);
		if(!CACHE.containsKey(key)){
			setCache(service, method);
		}
		
		return CACHE.get(key);
	}
	
	/**
	 * 放入缓存的值
	 * 
	 * @param service
	 * @param method
	 */
	public static void setCache(String service, String method){
		Object obj = SpringBeanUtil.getBeanByName(service);
		if(null == obj){
			throw new UtilException("not found service："+ service);
		}
		
		Class<?> cla = obj.getClass();
		Method[] methodsInCla = cla.getDeclaredMethods();
		
		Optional<Method> methodOp = Stream.of(methodsInCla).filter(me -> me.getName().equals(method)).findFirst();
		if(!methodOp.isPresent()){
			throw new UtilException("not found the service "+ service +"'s "+ method);
		}
		
		Method me = methodOp.get();
		
		MethodCache cache = new MethodCache();
		cache.setService(obj);
		cache.setMethod(me);
		cache.setParamTypes(me.getParameterTypes());
		cache.setReturnType(me.getReturnType());
		
		String key = getKey(service, method);
		CACHE.put(key, cache);
	}
	
	/**
	 * 获取map的key值
	 * 
	 * @param service
	 * @param method
	 * @return
	 */
	private static String getKey(String service, String method){
		return StringUtils.join('.', service, method);
	}
}
