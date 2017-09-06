package com.xiaosuo.aspectJ.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义注解的类型区分
 * 
 * @author suozhaoyu
 * @version 0.1
 */
public class AnnoTypeContant {

	private static final Map<String, Integer> annoTypeM;
	
	static{
		annoTypeM = new HashMap<>();
		annoTypeM.put("SpringBeanBeforeEven", 1);
		annoTypeM.put("SpringBeanAfterEven", 1 << 1);
		annoTypeM.put("SpringBeanExceptionEvent", 1 << 2);
	}
	
	/**
	 * 通过类的简单名称获取类型的值
	 * 
	 * @param simpleName
	 * @return
	 */
	public static int getAnnoType(String simpleName){
		if(annoTypeM.containsKey(simpleName)){
			return annoTypeM.get(simpleName);
		}
		
		return 0;
	}
}
