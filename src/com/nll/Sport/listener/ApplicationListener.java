package com.nll.Sport.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nll.Sport.util.FileUploadUtil;
import com.nll.Sport.util.StringUtil;


@WebListener
public class ApplicationListener implements ServletContextListener {
 public void contextDestroyed(ServletContextEvent sce)  { 
      
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application=sce.getServletContext();
    	String path=application.getInitParameter("uploadPath");
    	if(StringUtil.checkNull(path)) {
    		path="../pics";
    	}
    	File file=new File(application.getRealPath("/"),path);
    	if(!file.exists()) {
    		file.mkdirs();
    	}
    	FileUploadUtil.PATH=path;
    }
	
}
