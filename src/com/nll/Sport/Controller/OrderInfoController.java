package com.nll.Sport.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nll.Sport.biz.IOrderInfoBiz;
import com.nll.Sport.biz.impl.OrderInfoBizImpl;
import com.nll.Sport.entity.UserInfo;


@WebServlet("/order")
public class OrderInfoController extends BasicServlet{
	private static final long serialVersionUID = 2851940234139146738L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String op=req.getParameter("op");
       if("findByPage".equals(op)) {
    	   findByPage(req,resp);
       }else if("update".equals(op)){
    	   update(req,resp);
       }else if("add".equals(op)){
    	   add(req,resp);
       }else if("find".equals(op)){
    	   find(req,resp);
       }else if("total".equals(op)){
    	   total(req,resp);
       }else if("addcomment".equals(op)){
    	   addcomment(req,resp);
       }else if("ocomment".equals(op)){
    	   ocomment(req,resp);
       }else if("send".equals(op)){
    	   send(req,resp);
       }else if("pay".equals(op)){
    	   pay(req,resp);
       }
	}
	private void pay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oid=req.getParameter("oid");
		
		IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
		HttpSession session=req.getSession();
		session.setAttribute("totalPrice",req.getParameter("totalPrice"));
		this.send(resp,200,"",orderInfoBiz.pay(oid));// TODO Auto-generated method stub
		
	}
	private void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oid=req.getParameter("oid");
		IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
		
		this.send(resp,200,"",orderInfoBiz.send(oid));
	}
	private void ocomment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		int gid=Integer.parseInt(req.getParameter("gid"));
	    IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
    	this.send(resp,200,"",orderInfoBiz.ocomment(gid));
	}
	private void addcomment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int iid=Integer.parseInt(req.getParameter("iid"));
		String ocomment=req.getParameter("ocomment");
		IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
		
		this.send(resp,200,"",orderInfoBiz.addcomment(iid,ocomment));
		
	}
	private void total(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uid=Integer.parseInt(req.getParameter("uid"));
		IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
		
		this.send(resp,200,"",orderInfoBiz.total(uid));
		
	}
	private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     HttpSession session=req.getSession();
	     Object obj=session.getAttribute("currentLoginuser");
	     if(obj==null) {
	    	 this.send(resp, 500, "",null);
	    	 return;
	     }
	     int page=Integer.parseInt(req.getParameter("page"));
	     int rows=Integer.parseInt(req.getParameter("rows"));
		UserInfo mf=(UserInfo) obj;
		IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
		List<Map<String,String>> list=orderInfoBiz.finds(mf.getUid(),page,rows);
		
		if(list==null||list.isEmpty()) {
			this.send(resp, 200,null,null);
			return;
		}
		
		//返回的还是HashMap但是我们返回的是同一个订单放在一个map中
		List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		Map<String,Object>goods=null;
		
		String preOno=list.get(0).get("oid");//比较订单编号 是不是同一个订单
		String curOno=preOno;//当前的迭代变量
		
		Map<String,Object> map=new HashMap<String,Object>();//存放一个订单信息
		List<Map<String, Object>> temp=new ArrayList<Map<String,Object>>();//存一个订单下的所有商品信息

		//第一个订单数据
		map.put("oid",list.get(0).get("oid"));
		map.put("odate",list.get(0).get("odate"));
		map.put("totalprice",list.get(0).get("totalprice"));
		map.put("status",list.get(0).get("status"));

		
		for(Map<String,String>rt:list) {
		
				curOno=rt.get("oid");

			
			if(!preOno.equals(curOno)) {
				preOno=curOno;        //另一个订单
				map.put("goods", temp);
				result.add(map);
				
				map=new HashMap<String,Object>();
				temp=new ArrayList<Map<String,Object>>();//存放当前订单下所有商品信息
				map.put("oid",rt.get("oid"));
				map.put("odate",rt.get("odate"));
				map.put("totalprice",rt.get("totalprice"));
				map.put("status",rt.get("status"));
			}
			
			goods=new HashMap<String,Object>();
			goods.put("gname",rt.get("gname"));
			goods.put("pics",rt.get("pics").split(";")[0]);
			goods.put("weight",rt.get("weight"));
			goods.put("unit",rt.get("unit"));
			goods.put("nums",rt.get("nums"));
			goods.put("price",rt.get("price"));
			goods.put("filed",rt.get("filed"));
			goods.put("gid",rt.get("gid"));
			goods.put("iid",rt.get("iid"));
			goods.put("ocomment",rt.get("ocomment"));
			temp.add(goods);
		}
		map.put("goods", temp);
		result.add(map);
		
		
		this.send(resp, 200,"", result);
		
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cids=req.getParameter("cids");
		double totalPrice=Double.parseDouble(req.getParameter("totalPrice"));
		HttpSession session=req.getSession();
		session.setAttribute("totalPrice",totalPrice);
		String aid=req.getParameter("aid");
		int uid=Integer.parseInt(req.getParameter("uid"));
		IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
		int result=orderInfoBiz.add(cids, totalPrice,aid,uid);
		if(result>0) {
			this.send(resp, 200,null, null);
		}else {
			this.send(resp, 500,null, null);
		}
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp)
	{
       String oid=req.getParameter("oid");  
       int status=Integer.parseInt(req.getParameter("status"));
       IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
       this.send(resp, orderInfoBiz.update(oid, status)); ;
	}
	private void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int page=Integer.parseInt(req.getParameter("page"));
	    int rows=Integer.parseInt(req.getParameter("rows"));
	    
	    IOrderInfoBiz orderInfoBiz=new OrderInfoBizImpl();
	    this.send(resp, orderInfoBiz.findByPage(page, rows));
		
	}

}
