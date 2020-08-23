package com.nll.Sport.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.User;

import com.nll.Sport.biz.IAdminInfoBiz;
import com.nll.Sport.biz.ITypeInfoBiz;
import com.nll.Sport.biz.IUserInfoBiz;
import com.nll.Sport.biz.impl.AdminInfoBizImpl;
import com.nll.Sport.biz.impl.TypeInfoBizImpl;
import com.nll.Sport.biz.impl.UserInfoBizImpl;
import com.nll.Sport.entity.AdminInfo;
import com.nll.Sport.entity.UserInfo;
import com.nll.Sport.util.FileUploadUtil;
import com.nll.Sport.util.MyUtil;
import com.nll.Sport.util.RequestParamUtil;



@WebServlet("/user")
public class UserInfoController extends BasicServlet{

	private static final long serialVersionUID = 2288798257156942905L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("findByPage".equals(op)) {
			findByPage(req,resp);	
		}else if("update".equals(op)) {
			update(req,resp);			
		}else if("addphoto".equals(op)) {
			addphoto(req,resp);
		}else if("login".equals(op)) {
			login(req,resp);
		}else if("img".equals(op)) {
			img(req,resp);
		}else if("existname".equals(op)) {
			existname(req,resp);
		}else if("existemail".equals(op)) {
			existemail(req,resp);
		}else if("email".equals(op)) {
		    email(req,resp);
		}else if("register".equals(op)) {
			register(req,resp);
		}else if("repwd".equals(op)) {
			repwd(req,resp);
		}else if("info".equals(op)) {
			info(req,resp);
		}
	}
	private void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("currentLoginuser");
		if(obj==null) {
			this.send(resp, 500,"",null);
			return ;
		}
		this.send(resp,200,"",obj);
		
	}
	private void repwd(HttpServletRequest req, HttpServletResponse resp) {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		String verify=req.getParameter("verify");
		HttpSession session=req.getSession();
		String obj=(String) session.getAttribute("emailcode");
		if(verify.equalsIgnoreCase(obj)) {
			IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
			int result=userInfoBiz.repwd(email,pwd);
			this.send(resp, result);
	      
		}else {
			this.send(resp,500);
		}
		
		
	}
	private void register(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 2048, true);
		Map<String,String> map=fuu.upload(pagecontext);
		String code=map.get("verify");
		HttpSession session=req.getSession();
		System.out.println(session.getAttribute("emailcode"));
		String obj=(String) session.getAttribute("emailcode");
		if(code.equalsIgnoreCase(obj)) {
			IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
			int result=userInfoBiz.register( map.get("email"),map.get("pwd"),map.get("uname"),map.get("img_upload"));
			this.send(resp, result);
		}else {
			this.send(resp,500);
		}

		
	}
	private void email(HttpServletRequest req, HttpServletResponse resp) {
		String email=req.getParameter("email");
		HttpSession session=req.getSession();
		MyUtil mu=new MyUtil();
		session.setAttribute("emailcode",mu.sendMail(email));
		this.send(resp, 200);
		
	}
	private void existemail(HttpServletRequest req, HttpServletResponse resp) {
		String email=req.getParameter("email");
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		if(userInfoBiz.existemail(email)==null) {
			this.send(resp,200);
			return;
		}
		this.send(resp,500);
		
	}
	private void existname(HttpServletRequest req, HttpServletResponse resp) {
		String uname=req.getParameter("uname");
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		if(userInfoBiz.img(uname)==null) {
			this.send(resp,200);
			return;
		}
		this.send(resp,500);
		
		
	}
	private void img(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
	    //默认头像
	    String img="images/logo2.png";
		if(userInfoBiz.img(uname)==null) {
			this.send(resp, img);
			return;
		}
		img=(String) userInfoBiz.img(uname).get("photo");
		img=img.substring(0, img.length());

		this.send(resp,img);
		
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) {
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		String code=req.getParameter("verify");
		HttpSession session=req.getSession();
		String vcode=String.valueOf(session.getAttribute("validatecode"));
		if(!code.equalsIgnoreCase(vcode)) {
			this.send(resp, 500);
			
		}
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		UserInfo userInfo=userInfoBiz.login(uname, pwd);
		if(userInfo==null) {
			this.send(resp, 501);
			return;
		}
		if(userInfo.getStatus()==3) {
			this.send(resp, 503);
			return;
		}
		if(userInfo.getStatus()==2) {
			this.send(resp, 502);
			return;
		}
		session.setAttribute("currentLoginuser",userInfo);
		this.send(resp, 200);
		
		
	}
	private void addphoto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 2048, true);
		Map<String,String> map=fuu.upload(pagecontext);
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		int result=userInfoBiz.addphoto(Integer.parseInt(map.get("uid")),map.get("photo"));
		this.send(resp, result);
        

		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		UserInfo user=RequestParamUtil.getParams(UserInfo.class, req);
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		this.send(resp, userInfoBiz.update(user.getUid(), user.getEmail(), user.getUname(), user.getPhoto(), user.getStatus()));
	}
	private void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		this.send(resp,userInfoBiz.findByPage(page, rows));
		
	}

}
