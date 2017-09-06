package com.xiaosuo.common.util.bean;

import java.lang.reflect.Method;

/**
 * 方法缓存对象
 * 
 * @author suozhaoyu
 * @since  1.0
 */
public class MethodCache {

	/**
	 * 所属的service
	 */
	private Object service;
	/**
	 * 方法
	 */
	private Method method;
	/**
	 * 放入入参类型
	 */
	private Class<?>[] paramTypes;
	/**
	 * 出参类型
	 */
	private Class<?> returnType;
	
	
	/**
	 * @return 所属的service
	 */
	public Object getService() {
		return service;
	}
	/**
	 * @param 所属的service
	 */
	public void setService(Object service) {
		this.service = service;
	}
	/**
	 * @return 方法
	 */
	public Method getMethod() {
		return method;
	}
	/**
	 * @param 方法
	 */
	public void setMethod(Method method) {
		this.method = method;
	}
	/**
	 * @return 入参类型
	 */
	public Class<?>[] getParamTypes() {
		return paramTypes;
	}
	/**
	 * @param 入参类型
	 */
	public void setParamTypes(Class<?>[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	/**
	 * @return 出参类型
	 */
	public Class<?> getReturnType() {
		return returnType;
	}
	/**
	 * @param 出参类型
	 */
	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}
}
