package com.xiaosuo.simple.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * 测试service
 * 
 * @author suozhaoyu
 * @since  2017-08-30 15:23:08
 */
@Service
public class TestService {

	public void print(){
		System.out.println("This is Service");
	}
	
	public void testBefore(HttpServletRequest request){
//		throw new EventException("Before Event Break...");
		System.out.println("Before Event Break...");
	}
}
