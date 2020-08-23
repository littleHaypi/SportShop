package com.nll.Sport.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.nll.Sport.util.StringUtil;

@WebFilter(filterName="CharacterEncodingFilter",value="/*",initParams=@WebInitParam(name="encoding",value="utf-8"))
public class CharacterEncodingFilter implements Filter{
private String encoding="utf-8";

@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String temp=filterConfig.getInitParameter("encoding");
		if(!StringUtil.checkNull(temp)) {
			encoding=temp;
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);

	}

}
