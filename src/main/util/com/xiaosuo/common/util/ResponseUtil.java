package com.xiaosuo.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * 针对于response处理的工具类
 * 
 * @author suozhaoyu
 * @since  0.1.1
 */
public class ResponseUtil {

	/**
	 * 往外输出json数据
	 * 
	 * @param result
	 * @param message
	 * @param response
	 */
	public static void writeJson(boolean result, String message, HttpServletResponse response){
		Map<String, Object> resultM = new HashMap<>();
		resultM.put("result", result);
		resultM.put("msg", message);
		writeJson(resultM, response);
	}
	
	/**
	 * 往外输出json数据
	 * 
	 * @param resultM
	 * @param response
	 */
	public static void writeJson(Map<String, Object> resultM, HttpServletResponse response){
		JSONObject json = new JSONObject(resultM);
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(json.toString());
			out.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			out.close();
		}
	}
}
