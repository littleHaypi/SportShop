package com.nll.Sport.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CheckFrontFilter
 */
@WebFilter(filterName="CheckFrontFilter",value="/front/*")
public class CheckFrontFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
	   
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		if(request.getSession().getAttribute("currentLoginuser")==null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			String basePath=request.getScheme()+"://"+request.getServerName()+":"+req.getServerPort()+request.getContextPath()+"/";
		    out.print("<script>alert('请先登录..');location.href='"+basePath+"userLogin.html'</script>");
		    out.flush();
		    return;
		}
		String path=request.getRequestURI();
		
		String base=request.getContextPath();
		path=path.replace(base,"");
		request.getRequestDispatcher("../WEB-INF"+path).forward(request, response);
	return;
	}

}
