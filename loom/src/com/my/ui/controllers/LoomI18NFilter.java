package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoomI18NFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		HttpSession session=((HttpServletRequest)request).getSession();
		String lang=request.getParameter("lang");
		if(lang!=null&&lang.equalsIgnoreCase("EN"))
		{
			session.setAttribute("lan", "com.my.my");
		}
		else
		{
			session.setAttribute("lan", "com.my.my_te");
		}
		System.out.println(lang);
		fc.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
