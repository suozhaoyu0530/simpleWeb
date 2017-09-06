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

	public EventException(String message) {
		super(message);
		super.code = "5001";
	}

	public EventException(boolean iscontinue, String message) {
		super(message);
		this.iscontinue = iscontinue;
		super.code = "5001";
	}
	
	public EventException(String code, String message) {
		super(message);
		super.code = code;
	}
}
