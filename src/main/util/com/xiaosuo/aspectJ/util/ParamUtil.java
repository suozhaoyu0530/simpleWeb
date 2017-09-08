package com.xiaosuo.aspectJ.util;

import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import com.xiaosuo.common.util.BeanUtil;

/**
 * 对参数的处理工具
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public class ParamUtil {

	/**
	 * 根据规则获取入参的值
	 * 规则为prefix0, prefix1, prefix2此种
	 * 
	 * @param prefix
	 * @param rule
	 * @param inParam
	 * @return
	 */
	public static Object getParamObjByRuleWithPrefix(String prefix, String rule, Object[] inParams){
		int length = inParams.length;
		if(!rule.startsWith("arg")){
			return null;
		}
		
		String arg = rule.substring(3);
		if(!arg.matches("^\\d{1,}")){
			return null;
		}
		
		int index = Integer.parseInt(arg);
		if(index+1 >= length){
			return null;
		}
		
		return inParams[index];
	}
	
	/**
	 * 默认前缀arg
	 * 根据规则获取入参的值
	 * 规则为prefix0, prefix1, prefix2此种
	 * 
	 * @param rule
	 * @param inParam
	 * @return
	 */
	public static Object getParamObjByRuleWithPrefix(String rule, Object[] inParams){
		return getParamObjByRuleWithPrefix("arg", rule, inParams);
	}
	
	/**
	 * 根据规则获取入参的值
	 * 规则为prefix0.xxx, prefix1.xxx, request.xxx
	 * 
	 * @param rule
	 * @param inParams
	 * @param split
	 * @param prefix
	 * @return
	 */
	public static Object getParamObjByRuleSplit(String rule, Object[] inParams, char split, String prefix){
		if(rule.startsWith("request")){
			return getParamObjByRuleRequest(rule, inParams);
		}
		
		String[] splits = rule.split("\\.");
		Object obj = getParamObjByRuleWithPrefix(splits[0], inParams);
		
		try {
			for(int i = 1; i < splits.length; i++){
				obj = BeanUtil.getBeanPropertyValue(obj, splits[i]);
			}
		} catch (NoSuchFieldException | SecurityException | 
				IllegalArgumentException | IllegalAccessException e) {
			return null;
		}

		return obj;
	}
	
	/**
	 * 默认分隔符为.，默认开头为arg
	 * 根据规则获取入参的值
	 * 规则为prefix0.xxx, prefix1.xxx, request.xxx
	 * 
	 * @param rule
	 * @param inParams
	 * @return
	 */
	public static Object getParamObjByRuleSplit(String rule, Object[] inParams){
		return getParamObjByRuleSplit(rule, inParams, '.', "arg");
	}
	
	/**
	 * 默认分隔符为.
	 * 根据规则处理入参的值
	 * 规则为request.xxx
	 * 
	 * @param rule
	 * @param inParams
	 * @return
	 */
	public static Object getParamObjByRuleRequest(String rule, Object[] inParams){
		Optional<Object> requestOp = Stream.of(inParams)
				.filter(inParam -> inParam instanceof HttpServletRequest).findFirst();
		if(!requestOp.isPresent()){
			return null;
		}
		HttpServletRequest request = (HttpServletRequest) requestOp.get();
		
		String[] splits = rule.split("\\.");
		if(splits.length < 2){
			return null;
		}
		
		return request.getParameter(splits[1]);
	}
}
