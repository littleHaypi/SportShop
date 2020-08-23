package com.nll.Sport.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nll.Sport.util.SessionKey;
import com.nll.Sport.util.StringUtil;
@WebFilter(filterName="CheckBackLoginFilter",value="/front/manager/*",initParams=@WebInitParam(name="errorpage",value="back/index.html"))
public class CheckBackLoginFilter implements Filter{
private String path="index.html";

@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String temp=filterConfig.getInitParameter("errorpage");
		if(!StringUtil.checkNull(temp)) {
			path=temp;
		}
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
     HttpServletRequest request=(HttpServletRequest) req;
     HttpServletResponse response=(HttpServletResponse) resp;
		if(request.getSession().getAttribute(SessionKey.CURRENTLOGINADMIN)==null) {
			//
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			out.print("<script>alert('请先登录。。。');location.href='"+basePath+path+"'</script>");
			out.flush();
			out.close();
		}else {
			chain.doFilter(request, response);
		}
		
	
	}

}
