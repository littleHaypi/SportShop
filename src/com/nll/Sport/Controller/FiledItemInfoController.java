package com.nll.Sport.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nll.Sport.biz.IFiledItemInfoBiz;
import com.nll.Sport.biz.impl.FiledItemInfoBizImpl;
@WebServlet("/fileditem")
public class FiledItemInfoController extends BasicServlet{

	private static final long serialVersionUID = -1142881497273897872L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String op=req.getParameter("op");
	if("add".equals(op)) {
		add(req,resp);
	}else if("info".equals(op)) {
		info(req,resp);
	}
}

private void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int gid=Integer.parseInt(req.getParameter("gid"));
	IFiledItemInfoBiz filedItemInfoBiz=new FiledItemInfoBizImpl();
	this.send(resp,filedItemInfoBiz.info(gid));
	
}

private void add(HttpServletRequest req, HttpServletResponse resp) {
	int gid=Integer.parseInt(req.getParameter("gid"));
	int fid=Integer.parseInt(req.getParameter("fid"));
	String fname=req.getParameter("fname");
	String  n[]=fname.split(",");
	IFiledItemInfoBiz filedItemInfoBiz=new FiledItemInfoBizImpl();
	
	this.send(resp, filedItemInfoBiz.add(gid, fid, n));
	return;
}
}
