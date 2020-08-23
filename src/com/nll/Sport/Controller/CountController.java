package com.nll.Sport.Controller;

import java.io.IOException;
import java.time.Month;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nll.Sport.biz.ICountBiz;
import com.nll.Sport.biz.impl.CountBizImpl;
@WebServlet("/count")
public class CountController extends BasicServlet{

	private static final long serialVersionUID = -4920952006435068264L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String op=req.getParameter("op");
    	if("month".equals(op)) {
    		month(req,resp);
    	}else if("year".equals(op)) {
    		year(req,resp);
    	}else if("quarter".equals(op)) {
    		quarter(req,resp);
    	}else if("yearyear".equals(op)) {
    		yearyear(req,resp);
    	}else if("typepie".equals(op)) {
    		typepie(req,resp);
    	}
    }

	private void typepie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICountBiz countBiz=new CountBizImpl();
		this.send(resp, countBiz.typepie());
		
	}

	private void yearyear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICountBiz countBiz=new CountBizImpl();
		this.send(resp, countBiz.yearyear());
	}

	private void quarter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   int year=Integer.parseInt(req.getParameter("year"));
			ICountBiz countBiz=new CountBizImpl();
			this.send(resp, countBiz.quarter(year));
		
	}

	private void year(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   int year=Integer.parseInt(req.getParameter("year"));
			ICountBiz countBiz=new CountBizImpl();
			this.send(resp, countBiz.year(year));
		
	}

	private void month(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int month=Integer.parseInt(req.getParameter("month"));
	    int year=Integer.parseInt(req.getParameter("year"));
		ICountBiz countBiz=new CountBizImpl();
		this.send(resp, countBiz.month(year,month));
		
	}
}
