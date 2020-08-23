package com.nll.Sport.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nll.Sport.biz.IAdminInfoBiz;
import com.nll.Sport.biz.impl.AdminInfoBizImpl;
import com.nll.Sport.entity.AdminInfo;

@WebServlet("/admin")
public class AdminInfoController extends BasicServlet{

	private static final long serialVersionUID = -1342298704054929493L;
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String op=req.getParameter("op");
     if("login".equals(op)) {
    	 login(req,resp);
     }
    }
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aname=req.getParameter("aname");
		String pwd=req.getParameter("pwd");
		String code=req.getParameter("verify");
		HttpSession session=req.getSession();
		String vcode=String.valueOf(session.getAttribute("validatecode"));
		if(!code.equalsIgnoreCase(vcode)) {
			this.send(resp, 500);
			
		}
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		AdminInfo adminInfo=adminInfoBiz.login(aname, pwd);
		if(adminInfo==null) {
			this.send(resp, 501);
			return;
		}
		session.setAttribute("currentLoginadmin",adminInfo);
		this.send(resp, 200);
		
		
	}
}
