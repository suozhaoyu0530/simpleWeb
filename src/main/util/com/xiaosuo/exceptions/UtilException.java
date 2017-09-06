package com.xiaosuo.exceptions;

import com.xiaosuo.exceptions.base.SuoException;

/**
 * 工具类中的异常
 * 
 * @author suozhaoyu
 * @since  1.0
 */
@SuppressWarnings("serial")
public class UtilException extends SuoException{

	public UtilException(String msg) {
		super(msg);
	}
}
