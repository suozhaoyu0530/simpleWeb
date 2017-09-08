package com.xiaosuo.simple.service;

import org.springframework.stereotype.Service;

import com.xiaosuo.exceptions.EventException;

/**
 * 测试service
 * 
 * @author suozhaoyu
 * @since  2017-08-30 15:23:08
 */
@Service
public class TestService {

	public void print(String type){
		switch (type) {
		case "1":
			System.out.println("Hello World");
			break;

		default:
			throw new EventException("print method has a problem");
		}
	}
	
	public void testBefore(String type){
//		throw new EventException("Before Event Break...");
		System.out.println("Before Event the type's value is "+ type);
	}
}
