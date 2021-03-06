package com.xiaosuo.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaosuo.aspectJ.anno.SpringBeanAfterEven;
import com.xiaosuo.exceptions.EventException;
import com.xiaosuo.simple.bean.TUser;
import com.xiaosuo.simple.mapper.UserMapper;

/**
 * 测试service
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
@Service
public class TestService {
	
	@Autowired
	private UserMapper userMapper;

	@Transactional
	@SpringBeanAfterEven(service="testService", method="testAfter")
	public void print(String type){
		List<TUser> userL = userMapper.getTUserL();
		System.out.println(userL.size() +"====================");
		
		TUser user = new TUser();
		user.setUserName("John");
		user.setPassword("password");
		userMapper.insert(user);
	}
	
	public void testBefore(String type){
//		throw new EventException("Before Event Break...");
		switch (type) {
		case "1":
			System.out.println("Hello World");
			break;

		default:
			throw new EventException("print method has a problem");
		}
	}
	
	public void testAfter(String type){
		System.out.println("After Event Break...");
		switch (type) {
		case "1":
			System.out.println("Hello World");
			break;

		default:
			throw new EventException("print method has a problem");
		}
	}
	
	public void testMap(String type){
		System.out.println(type +"===================");
		switch (type) {
		case "1":
			System.out.println("test map success");
			break;

		default:
			throw new EventException("测试");
		}
	}
}
