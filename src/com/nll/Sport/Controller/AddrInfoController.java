package com.nll.Sport.Controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nll.Sport.biz.IAddrInfoBiz;
import com.nll.Sport.biz.ICartInfoBiz;
import com.nll.Sport.biz.impl.AddrInfoBizImpl;
import com.nll.Sport.biz.impl.CartInfoBizImpl;
import com.nll.Sport.entity.AddrInfo;
import com.nll.Sport.entity.CartInfo;
import com.nll.Sport.entity.UserInfo;
import com.nll.Sport.util.RequestParamUtil;
@WebServlet("/addr")
public class AddrInfoController extends BasicServlet {

	private static final long serialVersionUID = 3475651491480957197L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String op=req.getParameter("op");
		if("find".equals(op)) {
			find(req,resp);
		}else if("add".equals(op)) {
			add(req,resp);
		}else if("delete".equals(op)) {
			delete(req,resp);
		}else if("defaultAddr".equals(op)) {
			defaultAddr(req,resp);
		}
	}
	private void defaultAddr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid=Integer.parseInt(req.getParameter("uid"));
		String aid=req.getParameter("aid");
		IAddrInfoBiz addrInfoBiz=new AddrInfoBizImpl();
		if(addrInfoBiz.defaultAddr(uid,aid)>0) {
			this.send(resp, 200, "", null);
		}else {
			this.send(resp,500,"", null);
		}
		
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid=Integer.parseInt(req.getParameter("uid"));
		String aid=req.getParameter("aid");
		IAddrInfoBiz addrInfoBiz=new AddrInfoBizImpl();
		if(addrInfoBiz.delete(uid,aid)>0) {
			this.send(resp, 200, "", null);
		}else {
			this.send(resp,500,"", null);
		}
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddrInfo ai=RequestParamUtil.getParams(AddrInfo.class, req);
		IAddrInfoBiz addrInfoBiz=new AddrInfoBizImpl();
		String aid=UUID.randomUUID().toString();
		ai.setAid(aid);
		if(addrInfoBiz.add(ai)>0) {
			this.send(resp, 200, "", null);
		}else {
			this.send(resp,500,"", null);
		}

		
	}
	private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     HttpSession session=req.getSession();
	     Object obj=session.getAttribute("currentLoginuser");
	     if(obj==null) {
	    	
	    	 this.send(resp, 500, "",null);
	    	 return;
	     }
	 	UserInfo ui=(UserInfo) obj;
	 	
		IAddrInfoBiz addrInfoBiz=new AddrInfoBizImpl();
		
		List<AddrInfo> addrs=addrInfoBiz.finds(String.valueOf(ui.getUid()));
		
		if(addrs!=null&&!addrs.isEmpty()) {
			
			this.send(resp, 200, null, addrs);
			return;
		}
		this.send(resp, 500, null, null);
		
		return; 
		
	}

}
