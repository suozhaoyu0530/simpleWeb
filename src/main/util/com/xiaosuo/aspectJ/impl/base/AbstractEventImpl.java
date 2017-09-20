package com.xiaosuo.aspectJ.impl.base;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.xiaosuo.aspectJ.interfaces.AnnoEventInterface;
import com.xiaosuo.aspectJ.util.ParamUtil;
import com.xiaosuo.common.util.ServiceMethodCache;
import com.xiaosuo.common.util.StringUtils;
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
	public Object dealEvent(String service, String method, String paramRule, Object... params){
		/*
		 * 获取方法
		 */
		MethodCache cache = ServiceMethodCache.getCache(service, method);
		/*
		 * 获取调用方法的入参
		 */
		Object[] inParams = dealAnnoInParams(paramRule, cache.getParamTypes(), params);
		/*
		 * 调用方法
		 */
		Object obj = cache.getService();
		Object returnVal = null;
		try {
			returnVal = cache.getMethod().invoke(obj, inParams);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			if(e.getTargetException().getClass().getName().equals("com.xiaosuo.exceptions.EventException")){
				throw (EventException) e.getTargetException();
			}else{
				if(e.getTargetException() instanceof RuntimeException){
					throw (RuntimeException)e.getTargetException();
				}else{
					e.printStackTrace();
				}
			}
		}
		
		return returnVal;
	}
	
	/**
	 * 对返回值进行处理
	 * 
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
	 * 一般情况下的调用方法的入参处理
	 * 
	 * 
	 * @see com.xiaosuo.aspectJ.interfaces.EventInterface#dealNormalInParams(java.lang.Object[], java.lang.Object[])
	 */
	@Override
	public Object[] dealNormalInParams(Class<?>[] willTypes, Object[] inParams) {
		if(null == willTypes || willTypes.length == 0){
			return null;
		}
		
		int length = willTypes.length;
		Object[] willParams = new Object[length];
		
		List<Object> inParamL = Arrays.asList(inParams);
		List<Integer> hasIndex = new ArrayList<>();
		for(int i = 0; i < length; i++){
			Object obj = null;
			for(int j = 0; j < inParamL.size(); j++){
				if(hasIndex.contains(j)){
					continue;
				}
				if(willTypes[i].isAssignableFrom(inParamL.get(j).getClass()) || willTypes[i].isInstance(inParamL.get(j))){
					obj = inParamL.get(j);
					hasIndex.add(j);
				}
			}
			willParams[i] = obj;
		}
		
		return willParams;
	}

	/**
	 * 注解下的调用方法的入参处理
	 * 
	 * @see com.xiaosuo.aspectJ.interfaces.AnnoEventInterface#dealAnnoInParams(java.lang.Object[], java.lang.Object[])
	 */
	@Override
	public Object[] dealAnnoInParams(String paramRule, Class<?>[] willTypes, Object[] inParams) {
		if(StringUtils.isBlank(paramRule)){
			return dealNormalInParams(willTypes, inParams);
		}
		
		String[] rules = paramRule.split(",");
		Object[] dealParams = new Object[rules.length];
		for(int i = 0; i < rules.length; i++){
			Object obj = getParamsByRule(rules[i], inParams);
			if(null != obj){
				dealParams[i] = obj;
			}
		}
		
		return dealNormalInParams(willTypes, dealParams);
	}
	
	/**
	 * 通过规则获取数据
	 * 
	 * @param rule
	 * @param inParams
	 * @return
	 */
	protected Object getParamsByRule(String rule, Object[] inParams){
		/*
		 * 判断是否为argx.xxx，或者request.xxx
		 */
		if(rule.contains(".")){
			return ParamUtil.getParamObjByRuleSplit(rule, inParams);
		}else{
			return ParamUtil.getParamObjByRuleWithPrefix(rule, inParams);
		}
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
