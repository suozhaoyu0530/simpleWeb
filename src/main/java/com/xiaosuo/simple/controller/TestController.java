package com.xiaosuo.simple.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xiaosuo.aspectJ.anno.SpringBeanBeforeEven;
import com.xiaosuo.common.util.ResponseUtil;
import com.xiaosuo.simple.service.TestService;

/**
 * 用来测试的controller
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
@RestController
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping({"/","/index.do"})
	public String test(HttpServletRequest request){
		System.out.println("========================Normal Event==========================");
		String type = request.getParameter("type");
		System.out.println("事中："+ type);
		
		return "index";
	}
	
	@RequestMapping("/main.do")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("index");
		
		String type = request.getParameter("type");
		testService.print(type);
		
		return mv;
	}
	
	@RequestMapping("/testMap.do")
	@ResponseBody
	public Map<String, Object> testMap(String type){
		testService.testMap(type);
		
		Map<String, Object> resultM = new HashMap<>();
		resultM.put("result", true);
		resultM.put("msg", "测试正确");
		return resultM;
	}
	
	@RequestMapping("/testVoid.do")
	@SpringBeanBeforeEven(service="testService", method="testMap", paramRule="request.type")
	public void testVoid(HttpServletRequest request, HttpServletResponse response){
		ResponseUtil.writeJson(true, "测试正确", response);
	}
}
