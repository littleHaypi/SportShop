package com.nll.Sport.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.nll.Sport.biz.ITypeInfoBiz;
import com.nll.Sport.biz.IUserInfoBiz;
import com.nll.Sport.biz.impl.TypeInfoBizImpl;
import com.nll.Sport.biz.impl.UserInfoBizImpl;
import com.nll.Sport.entity.TypeInfo;
import com.nll.Sport.entity.UserInfo;
import com.nll.Sport.util.FileUploadUtil;
import com.nll.Sport.util.RequestParamUtil;

@WebServlet("/type")
public class TypeInfoController extends BasicServlet{

	private static final long serialVersionUID = -8339363502526847000L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        if("findByPage".equals(op)) {
        	findByPage(req,resp);
        }else if("addphoto".equals(op)) {
        	addphoto(req,resp);
        }else if("add".equals(op)) {
        	add(req,resp);
        }else if("update".equals(op)) {
        	update(req,resp);
        }else if("findAll".equals(op)) {
        	findAll(req,resp);
        }
    }
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ITypeInfoBiz typeInfoBiz=new TypeInfoBizImpl();
		this.send(resp, typeInfoBiz.findAll());
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		TypeInfo type=RequestParamUtil.getParams(TypeInfo.class, req);
		ITypeInfoBiz typeInfoBiz=new TypeInfoBizImpl();
		this.send(resp, typeInfoBiz.update(type.getTid(), type.getTname()));
	
		
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 2048, true);
		Map<String,String> map=fuu.upload(pagecontext);
		ITypeInfoBiz typeInfoBiz=new TypeInfoBizImpl();
		int result=typeInfoBiz.add(map.get("tname"),map.get("photo"));
		this.send(resp, result);
       
		
	}
	private void addphoto(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 2048, true);
		Map<String,String> map=fuu.upload(pagecontext);
		ITypeInfoBiz typeInfoBiz=new TypeInfoBizImpl();
		int result=typeInfoBiz.addphoto(Integer.parseInt(map.get("tid")),map.get("pic"));
		this.send(resp, result);
        
		
	}
	private void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      int page=Integer.parseInt(req.getParameter("page"));
	      int rows=Integer.parseInt(req.getParameter("rows"));
	      ITypeInfoBiz typeInfoBiz=new TypeInfoBizImpl();
	      this.send(resp,typeInfoBiz.findsByPage(page, rows));
	      
		
	}
}
