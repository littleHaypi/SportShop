package com.nll.Sport.Controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nll.Sport.biz.ICartInfoBiz;
import com.nll.Sport.biz.impl.CartInfoBizImpl;
import com.nll.Sport.entity.CartInfo;
import com.nll.Sport.entity.UserInfo;
import com.nll.Sport.util.RequestParamUtil;


@WebServlet("/cart")
public class CartInfoController extends BasicServlet{
	private static final long serialVersionUID = -1584948544190801L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String op=req.getParameter("op");
      if("info".equals(op)) {
    	  info(req,resp);
      }else if("update".equals(op)) {
  		update(req,resp);
  	}else if("add".equals(op)) {
  		add(req,resp);
  	}else if("find".equals(op)) {
  		find(req,resp);
  	}else if("findByCids".equals(op)) {
  		findByCids(req,resp);
  	}
    }

	private void findByCids(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String cids=req.getParameter("cids");
		 ICartInfoBiz cartInfoBiz=new CartInfoBizImpl();
		 this.send(resp, 200, "",cartInfoBiz.findByCids(cids));
		
	}

	private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     HttpSession session=req.getSession();
	     Object obj=session.getAttribute("currentLoginuser");
	     if(obj==null) {
	    	 this.send(resp, 500, "",null);
	    	 return;
	     }
	 	ICartInfoBiz cartInfoBiz=new CartInfoBizImpl();
	 	UserInfo ui=(UserInfo)obj;
	 
	 	
	 	this.send(resp,200,"",cartInfoBiz.finds(String.valueOf(ui.getUid())));
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartInfo cf=RequestParamUtil.getParams(CartInfo.class, req);
		ICartInfoBiz cartInfoBiz=new CartInfoBizImpl();
		String cid=UUID.randomUUID().toString();
		cf.setCid(cid);
		if(cartInfoBiz.add(cf)>0) {
			this.send(resp, 200, cid, null);
		}else {
			this.send(resp,500,"", null);
		}

		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid=req.getParameter("cid");
		CartInfo cf=RequestParamUtil.getParams(CartInfo.class, req);
		int num=Integer.parseInt(req.getParameter("num"));
		ICartInfoBiz cartInfoBiz=new CartInfoBizImpl();
		int result=cartInfoBiz.updateNum(cid, num);
		if(result>0) {
			this.send(resp, 200, "", null);
		}else {
			this.send(resp,500,"", null);
		}

		
	}

	private void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("currentLoginuser");
		if(obj==null) {
			this.send(resp,500,"",null);
			return;
		}
		ICartInfoBiz cartInfoBiz=new CartInfoBizImpl();
		UserInfo ui=(UserInfo)obj;
		this.send(resp, 201,"",cartInfoBiz.findCart(String.valueOf(ui.getUid())));
		
	}
}
