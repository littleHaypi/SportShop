package com.nll.Sport.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sun.jmx.snmp.Enumerated;

public class FileUploadUtil {
public static String PATH="../pics";
private static final String ALLOWEDLIST="gif,jpg,png,jpeg,doc,doxc,xls,txt,jfif";
private static final int MAXFILESIZE=10*1024*1024;
private static final int TOTALMAX=100*1024*1024;
private static String basePath;
public Map<String,String> upload(PageContext pagecontext){
	Map<String, String> map=new HashMap<String,String>();
	try {
		
		//实例化上传组件
		SmartUpload su=new SmartUpload();
		su.initialize(pagecontext);
		
		//设置参数
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAX);
		su.setAllowedFilesList(ALLOWEDLIST);
		su.setCharset("utf-8");
		su.upload();//开始上传
		
		//获取非文件参数
		Request req=su.getRequest();
		Enumeration<String> enums=req.getParameterNames();
		
		String name=null;
		while(enums.hasMoreElements()) {
			name=enums.nextElement();
			map.put(name, req.getParameter(name));
		}
		Files files=su.getFiles();
		if(files==null||files.getCount()<=0) {
			return map;
		}

		
		Collection<File> fls=files.getCollection();
		
		 basePath = pagecontext.getServletContext().getRealPath("/");
		 String filedName=null;
		 String fileName=null;
		 String temp=null;
		 String pathStr="";
		 
		for(File fl:fls) {
			if(!fl.isMissing()) {
				temp=fl.getFieldName();
				if(StringUtil.checkNull(filedName)) {
					filedName=temp;
					
				}else {
					if(!temp.equals(filedName)) {
						map.put(filedName,pathStr);
						pathStr="";
						filedName=temp;
					}
					
				}
			fileName=PATH+"/"+new Date().getTime()+"_"+fl.getFileName();
			
			if(StringUtil.checkNull(pathStr)) {
				pathStr=fileName;
				
			}else {
				pathStr+=","+fileName;
			}
				fl.saveAs(basePath+fileName, SmartUpload.SAVE_PHYSICAL);
				String logoText = "小太阳运动商城";
				WaterMarkUtil2.markImageByText(logoText,basePath+fileName,basePath+fileName);
				WaterMarkUtil2.setImageMarkOptions(0.5f, 1, 1, null, null);
			     WaterMarkUtil2.markImageByIcon("D:\\users\\nll\\Desktop\\logo2.png",basePath+fileName,basePath+fileName);

	    	}
		
			
		}

		map.put(filedName, pathStr);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return map;
	
	
}

/**
 * 单文件与的单文件
 * @param pagecontext
 * @return
 */
public Map<String,String> uploadPic(PageContext pagecontext){
	Map<String, String> map=new HashMap<String,String>();
	try {
		
		//实例化上传组件
		SmartUpload su=new SmartUpload();
		su.initialize(pagecontext);
		
		//设置参数
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAX);
		su.setAllowedFilesList(ALLOWEDLIST);
		su.setCharset("utf-8");
		su.upload();//开始上传
		
	
		Files files=su.getFiles();
		if(files==null||files.getCount()<=0) {
			return map;
		}

		
		Collection<File> fls=files.getCollection();
		
		 basePath = pagecontext.getServletContext().getRealPath("/");
		 String filedName=null;
		 String fileName=null;
		 String uploadPath=null;
	
		 
		for(File fl:fls) {
			if(!fl.isMissing()) {
            filedName=fl.getFieldName();
            fileName=fl.getFileName();
            uploadPath=PATH+"/"+new Date().getTime()+"_"+fl.getFileName();
	        fl.saveAs(basePath+uploadPath, SmartUpload.SAVE_PHYSICAL);
			}
		
			
		}
		map.put(filedName,uploadPath);
		map.put("fileName",fileName);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SmartUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return map;
	
	
}
public <T> T upload(Class<T> clazz,PageContext pagecontext) throws Exception{
	
		T t=clazz.newInstance();
		//实例化上传组件
		SmartUpload su=new SmartUpload();
		su.initialize(pagecontext);
		
		//设置参数
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAX);
		su.setAllowedFilesList(ALLOWEDLIST);
		su.setCharset("utf-8");
		su.upload();//开始上传
		
		//获取非文件参数
		Request req=su.getRequest();
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
		Files files=su.getFiles();
		if(files==null||files.getCount()<=0||files.getFile(0).getSize()<=0||files.getSize()<=0) {
			return t;
		}

		
		Collection<File> fls=files.getCollection();
		
		 basePath = pagecontext.getRequest().getRealPath("/");
		 String fieldName=null;
		 String fileName=null;
		 String temp=null;
		 String pathStr="";
		 
		for(File fl:fls) {
			if(!fl.isMissing()) {
				temp=fl.getFieldName();
				if(StringUtil.checkNull(fieldName)) {
					fieldName=temp;
					
				}else {
					if(!temp.equals(fieldName)) {
						
						methodName="set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
						method=setters.get(methodName);
						if(method==null) {
							continue;
						}
						
						types=method.getParameterTypes();
						if(types==null) {
							continue;
						}
						method.invoke(t,pathStr);
						pathStr="";
						fieldName=temp;
					}
					
				}
			fileName=PATH+"/"+new Date().getTime()+"_"+fl.getFileName();
			if(StringUtil.checkNull(pathStr)) {
				pathStr=fileName;
				
			}else {
				pathStr+=","+fileName;
			}
			   
				fl.saveAs(basePath+fileName, SmartUpload.SAVE_PHYSICAL);
			}
		
			
		}
		methodName="set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
		method=setters.get(methodName);
		if(method==null) {
			return t;
		}
		types=method.getParameterTypes();
		if(types==null) {
			return t;
		}
		method.invoke(t, pathStr);
		System.out.println("chuqu");
		return t;
	
	
	
}
}
