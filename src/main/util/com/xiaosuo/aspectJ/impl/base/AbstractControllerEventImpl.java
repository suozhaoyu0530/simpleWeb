package com.xiaosuo.aspectJ.impl.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.xiaosuo.exceptions.UtilException;

/**
 * 针对controller的事件实现
 * 
 * @author suozhaoyu
 * @since  0.1
 */
public abstract class AbstractControllerEventImpl extends AbstractEventImpl{

	/**
	 * 针对string类型的返回值和void特殊处理
	 * 
	 * @see com.xiaosuo.aspectJ.impl.base.AbstractEventImpl#dealReturnValue(java.lang.Exception, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object dealReturnValue(Exception e, String returnType, Object[] params) {
		if("java.lang.String".equals(returnType)){
			Optional<Object> requestOp = Stream.of(params)
					.filter(inParam -> inParam instanceof HttpServletRequest)
					.findFirst();
			if(!requestOp.isPresent()){
				throw new UtilException("未获得入参中的request对象");
			}
			HttpServletRequest request = (HttpServletRequest) requestOp.get();
			String message = super.defaultReturnStr(e);
			request.setAttribute("msg", message);
			return "error";
		}
		
		if("void".equals(returnType)){
			Optional<Object> responseOp = Stream.of(params).filter(inParam -> inParam instanceof HttpServletResponse).findFirst();
			if(!responseOp.isPresent()){
				throw new UtilException("未获得入参中的response对象");
			}
			HttpServletResponse response = (HttpServletResponse) responseOp.get();
			Map<String, Object> resultM = super.defaultReturnMap(e);
			JSONObject json = new JSONObject(resultM);
			
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
			
			return null;
		}
		
		return super.dealReturnValue(e, returnType, params);
	}
}
