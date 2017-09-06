package com.xiaosuo.exceptions.base;

/**
 * 项目的基础异常
 * 
 * @author suozhaoyu
 * @version 0.1
 */
@SuppressWarnings("serial")
public class SuoException extends RuntimeException{

	/**
	 * 错误编号
	 */
	public String code;
	/**
	 * 错误信息
	 */
	public String message;
	
	public SuoException(){}
	public SuoException(String message) {
		super(message);
	}
}
