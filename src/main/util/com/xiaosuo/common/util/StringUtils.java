package com.xiaosuo.common.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 字符串的工具类
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
public class StringUtils {

	/**
	 * 字符串为空判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(null == str || "".equals(str)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 字符串不为空判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str){
		if(null == str || "".equals(str)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 拼接字符串
	 * 
	 * @param join：拼接字符
	 * @param strs
	 * @return
	 */
	public static String join(char join, String...strs){
		String joinStr = Character.toString(join);
		return Stream.of(strs).collect(Collectors.joining(joinStr));
	}
	
	
	/**
	 * 拼接字符串，默认分隔符,
	 * 
	 * @param strs
	 * @return
	 */
	public static String join(String...strs){
		return join(',', strs);
	}
}
