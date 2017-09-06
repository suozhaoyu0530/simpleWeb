package com.xiaosuo.aspectJ.impl.base;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.xiaosuo.aspectJ.interfaces.AnnoEventInterface;
import com.xiaosuo.common.util.ServiceMethodCache;
import com.xiaosuo.common.util.bean.MethodCache;
import com.xiaosuo.exceptions.EventException;
import com.xiaosuo.exceptions.base.SuoException;

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
	
	/* (non-Javadoc)
	 * @see com.xiaosuo.aspectJ.interfaces.EventInterface#dealReturnValue(java.lang.Exception, java.lang.String)
	 */
	@Override
	public Object dealReturnValue(Exception e, String returnType, Object[] params) {
		if("java.util.Map".equals(returnType)){
			return defaultReturnMap(e);
		}
		
		if("org.springframework.web.servlet.ModelAndView".equals(returnType)){
			return defaultReturnMv(e);
		}
		
		if("java.lang.String".equals(returnType)){
			return defaultReturnStr(e);
		}
		
		return null;
	}

	/**
	 * 默认的返回值为map的
	 * 
	 * @param e
	 * @return
	 */
	protected Map<String, Object> defaultReturnMap(Exception e){
		Map<String, Object> resultM = new HashMap<>();
		resultM.put("result", false);
		
		if(e instanceof SuoException){
			resultM.put("msg", e.getMessage());
		}else{
			resultM.put("msg", "服务器错误");
		}
		
		return resultM;
	}
	
	/**
	 * 默认的返回值为modelAndView的
	 * 
	 * @param e
	 * @return
	 */
	protected ModelAndView defaultReturnMv(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		if(e instanceof SuoException){
			mv.addObject("msg", e.getMessage());
		}else{
			mv.addObject("msg", "服务器错误");
		}
		
		return mv;
	}
	
	/**
	 * 默认的返回值为string
	 * 
	 * @param e
	 * @return
	 */
	protected String defaultReturnStr(Exception e) {
		return e.getMessage();
	}
}
