package org.springframework.mvc;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

public class PreParameterProcess {
	public Object[] process(Method method, HttpServletRequest request) 
			throws Exception {
		// 메서드에서 파라미터 정보를 추출하자
		// update(int no, String title)
		Parameter[] pArr = method.getParameters();
		
		int index = 0;
		Object[] rArr = new Object[pArr.length];
		
		for (Parameter p : pArr) {
			// Parameter p -> int no
			
			// Class<?> pType -> int
			Class<?> pType = p.getType();
			// tName -> int
			String tName = pType.getSimpleName();
			
			
			// @RequestParam(value="no") int no
			// 파라미터 이름 : no
			String name = p.getName();
			
			RequestParam rp = p.getAnnotation(RequestParam.class);
			String defaultValue = "";
			if (rp != null) {
				name = rp.value();
				defaultValue = rp.defaultValue();
			}
			
			switch (tName) {
			case "int":
				String pValue = request.getParameter(name);
				if (pValue == null) {
					pValue = defaultValue;
				}
				rArr[index++] = Integer.parseInt(pValue);
				break;
			case "HttpServletRequest":
				rArr[index++] = request;
				break;
			default: 
				rArr[index++] = WebUtil.getParamToVO(request, pType);
			}
			
		}
		
		return rArr;
	}
}














