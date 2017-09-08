package com.xiaosuo.common.util;

import java.lang.reflect.Field;

/**
 * bean的工具类
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public class BeanUtil {

	/**
	 * 获取bean成员变量的值
	 * 
	 * @param obj
	 * @param property
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object getBeanPropertyValue(Object obj, String property) 
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class<?> cla = obj.getClass();
		Field field = cla.getDeclaredField(property);
		field.setAccessible(true);
		return field.get(obj);
	}
}
