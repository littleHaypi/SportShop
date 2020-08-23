package com.nll.Sport.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nll.Sport.biz.IFiledInfoBiz;
import com.nll.Sport.biz.ITypeInfoBiz;
import com.nll.Sport.biz.impl.FiledInfoBizImpl;
import com.nll.Sport.biz.impl.TypeInfoBizImpl;
import com.nll.Sport.entity.FiledInfo;
import com.nll.Sport.util.RequestParamUtil;



@WebServlet("/filed")
public class FiledInfoController extends BasicServlet{
	private static final long serialVersionUID = -8301049438852786760L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String op=req.getParameter("op");
	if("findByPage".equals(op)){
		findByPage(req,resp);
	}else if("add".equals(op)){
		add(req,resp);
	}else if("findAll".equals(op)){
		findAll(req,resp);
	}
		
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		IFiledInfoBiz filedInfoBiz=new FiledInfoBizImpl();
		this.send(resp,filedInfoBiz.findAll());
		
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		FiledInfo filed=RequestParamUtil.getParams(FiledInfo.class, req);
		IFiledInfoBiz filedInfoBiz=new FiledInfoBizImpl();
		this.send(resp, filedInfoBiz.add(filed));
		
	}
	private void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		IFiledInfoBiz filedInfoBiz=new FiledInfoBizImpl();
	    this.send(resp, filedInfoBiz.findByPage(page, rows));
		
	}

}
