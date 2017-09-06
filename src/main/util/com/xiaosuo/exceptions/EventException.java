package com.xiaosuo.exceptions;

import com.xiaosuo.exceptions.base.SuoException;

/**
 * 事件异常
 * 
 * @author suozhaoyu
 * @version 0.1
 */
@SuppressWarnings("serial")
public class EventException extends SuoException {
	/**
	 * 是否继续
	 */
	public boolean iscontinue = false;
	/**
	 * 返回信息
	 */
	public Object result;

	public EventException() {
		super();
		super.code = "5001";
		super.message = "事件错误";
	}

	public EventException(boolean iscontinue) {
		super();
		this.iscontinue = iscontinue;
		super.code = "5001";
		super.message = "事件错误";
	}
	
	public EventException(Object result) {
		super();
		super.code = "5001";
		super.message = "事件错误";
		this.result = result;
	}
	public EventException(String message, Object result) {
		super();
		super.code = "5001";
		super.message = message;
		this.result = result;
	}
	public EventException(boolean iscontinue, String code, String message) {
		super();
		this.iscontinue = iscontinue;
		super.code = code;
		super.message = message;
	}
	public EventException(String code, String message, Object result) {
		super();
		super.code = code;
		super.message = message;
		this.result = result;
	}
	public EventException(boolean iscontinue, String code, String message, Object result) {
		super();
		this.iscontinue = iscontinue;
		super.code = code;
		super.message = message;
		this.result = result;
	}
}
