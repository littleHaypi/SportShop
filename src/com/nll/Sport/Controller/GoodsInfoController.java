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

import com.nll.Sport.biz.IGoodsInfoBiz;
import com.nll.Sport.biz.IUserInfoBiz;
import com.nll.Sport.biz.impl.GoodsInfoBizImpl;
import com.nll.Sport.biz.impl.UserInfoBizImpl;
import com.nll.Sport.entity.GoodsInfo;
import com.nll.Sport.entity.UserInfo;
import com.nll.Sport.util.FileUploadUtil;
import com.nll.Sport.util.RequestParamUtil;

@WebServlet("/good")
public class GoodsInfoController extends BasicServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String op=req.getParameter("op");
	   if("findByPage".equals(op)) {
		   findByPage(req,resp);
	   }else if("findByCondition".equals(op)) {
		   findByCondition(req,resp);
	   }else if("update".equals(op)) {
			update(req,resp);	
		}else if("add".equals(op)) {
			add(req,resp);	
		}else if("findIndex".equals(op)) {
			findIndex(req,resp);	
		}else if("findByGid".equals(op)) {
			findByGid(req,resp);	
		}else if("upload".equals(op)) {
			upload(req,resp);	
		}else if("findByTid".equals(op)) {
			findByTid(req,resp);	
		}else if("findByNews".equals(op)) {
			findByNews(req,resp);	
		}else if("gprice".equals(op)) {
			gprice(req,resp);	
		}else if("gsales".equals(op)) {
			manUse(req,resp);	
		}else if("findByTids".equals(op)) {
			findByTids(req,resp);	
		}else if("gprice1".equals(op)) {
			gprice1(req,resp);	
		}else if("gsales1".equals(op)) {
			manUse1(req,resp);	
		}else if("findByNewstname".equals(op)) {
			findByNewstname(req,resp);	
		}
	}
	private void findByNewstname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tname=req.getParameter("tname");
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200,"", goodsInfoBiz.findByNewstname(tname));

	}
	private void manUse1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(req.getParameter("tid"));
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.manUse1(tid,page,rows));
		
	}
	private void gprice1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer page=Integer.parseInt(req.getParameter("page"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.gprice1(tid,page,rows));
		
	}
	private void findByTids(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer page=Integer.parseInt(req.getParameter("page"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.findByTids(tid,page,rows));
	}
	
	private void manUse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer page=Integer.parseInt(req.getParameter("page"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.manUse(tid,page,rows));
		
	}
	private void gprice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer page=Integer.parseInt(req.getParameter("page"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.gprice(tid,page,rows));
		
	}
	private void findByNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.findByNews(tid));
		
	}
	private void findByTid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer tid=Integer.parseInt(req.getParameter("tid"));
		Integer page=Integer.parseInt(req.getParameter("page"));
		Integer rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.findByTid(tid,page,rows));
		
	}
	private void upload(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null,true, 2048,true);
        Map<String,String> map=fuu.uploadPic(pagecontext);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("fileName", map.get("fileName"));
        result.put("url","../../"+ map.getOrDefault("upload", ""));
        result.put("uploaded", 1);
        System.out.println(result);
        try {
			this.send(resp, result);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void findByGid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gid=req.getParameter("gid");
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200, "",goodsInfoBiz.findByGid(gid));
	}
	private void findIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, 200,"",goodsInfoBiz.findIndex());
		
	}
	private void add(HttpServletRequest req, HttpServletResponse resp) {

		FileUploadUtil fuu=new FileUploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 2048, true);
		Map<String,String> map=fuu.upload(pagecontext);
        IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		int result=goodsInfoBiz.add(map.get("gname"), Integer.parseInt(map.get("tid")),
			Double.parseDouble(map.get("price")), map.get("intro"),
			 Integer.parseInt(map.get("balance")),map.get("pics"),map.get("unit")
			 ,map.get("weight"),map.get("descr"),Integer.parseInt(map.get("status")));
		System.out.println(result);
		this.send(resp, result);
        System.out.println(map);
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		GoodsInfo goodsInfo=RequestParamUtil.getParams(GoodsInfo.class, req);
		IGoodsInfoBiz goodInfoBiz=new GoodsInfoBizImpl();
		String weight=goodsInfo.getWeight();
	    String str[]=weight.split("/");
	    goodsInfo.setWeight(str[0]);
	    goodsInfo.setUnit(str[1]);
		this.send(resp, goodInfoBiz.update(goodsInfo));
	
	}
	private void findByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		String tid=req.getParameter("tid");
		String gname=req.getParameter("gname");
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
		this.send(resp, goodsInfoBiz.findByCondition(tid,gname,page, rows));
		
	}
	private void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz=new GoodsInfoBizImpl();
	    this.send(resp, goodsInfoBiz.findByPage(page, rows));
		
	}

}
