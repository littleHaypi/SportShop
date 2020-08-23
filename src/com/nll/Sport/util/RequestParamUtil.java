package com.nll.Sport.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestParamUtil {
public static <T> T getParams(Class<T> clazz,HttpServletRequest req) {
	T t=null;
	 try {
		t=clazz.newInstance();
		
		Enumeration<String> enums=req.getParameterNames();
		

		Method[] methods=clazz.getMethods();
		
		Map<String,Method> setters=new HashMap<String,Method>();
		
		String methodName=null;
		
		   for(Method method:methods) {
			   methodName=method.getName();
			   if(methodName.startsWith("set")) {
				   setters.put(methodName, method);
			   }
			   
		   }
		String name=null;
		Method method=null;
		Class<?>[] types=null;
		Class<?> type=null;
		
		while(enums.hasMoreElements()) {
			name=enums.nextElement();
			methodName="set"+name.substring(0, 1).toUpperCase()+name.substring(1);
			
			method=setters.get(methodName);
			
			if(method==null) {
				continue;
				
			}
			
			types=method.getParameterTypes();
			
			if(types==null) {
			continue;
			}
			type=types[0];
			
			if(Integer.TYPE==type||Integer.class==type) {
				method.invoke(t,Integer.valueOf(req.getParameter(name)));
			}else if(Float.TYPE==type||Float.class==type) {
				method.invoke(t,Float.valueOf(req.getParameter(name)));
			}else if(Double.TYPE==type||Double.class==type) {
				method.invoke(t,Double.valueOf(req.getParameter(name)));
			}else {
				method.invoke(t,req.getParameterValues(name));
			}

		}
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return t;
	
}
public Map<String,String> upload(HttpServletRequest request){
	Map<String,String> map=new HashMap<String,String>();
	Enumeration<String> enums=request.getParameterNames();
	String name=null;
	
	while(enums.hasMoreElements()) {
		name=enums.nextElement();
		map.put(name, request.getParameter(name));
	}
	return map;
	
	
}
}
