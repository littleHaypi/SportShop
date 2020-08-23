package com.nll.Sport.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6130167472046054877L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		super.service(req, resp);
	}
	   
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     doPost(req, resp);
	}
	protected void send(HttpServletResponse resp,String str) throws ServletException, IOException {
		
	         PrintWriter out=resp.getWriter();
			 out.println(str);
		     out.flush();
	} 
	protected void send(HttpServletResponse resp,int code)  {
		
        PrintWriter out;
		try {
			out = resp.getWriter();
			 out.println(code);
		     out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
} 
	protected void send(HttpServletResponse resp,Object obj) throws ServletException, IOException {
		 Gson gson=new GsonBuilder().serializeNulls().create();
         PrintWriter out=resp.getWriter();
		 out.println(gson.toJson(obj));
	     out.flush();
		}
	protected void send(HttpServletResponse resp,int code,String msg,Object obj) throws ServletException, IOException {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", code);
		map.put("msg",msg);
		map.put("data", obj);
		
		Gson gson=new GsonBuilder().serializeNulls().create();
        PrintWriter out=resp.getWriter();
		 out.println(gson.toJson(map));
	     out.flush();
		}
	protected void send(HttpServletResponse resp, int total, Object obj) throws IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", obj);
		 Gson gson=new GsonBuilder().serializeNulls().create();
         PrintWriter out=resp.getWriter();
		 out.println(gson.toJson(map));
	     out.flush();
	}

}
