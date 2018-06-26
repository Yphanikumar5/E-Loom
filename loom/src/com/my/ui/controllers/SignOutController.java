package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.ui.Controller;

public class SignOutController implements Controller{

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				
					for(Cookie c:cookies)
					{
						if(c.getName().equalsIgnoreCase("loomusername"))
						{
							c.setMaxAge(0);
							response.addCookie(c);
							
							break;
						}
					}
					for(Cookie c:cookies)
					{
						if(c.getName().equalsIgnoreCase("loompassword"))
						{
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
					
			}
		}
		response.sendRedirect("showlogin");
		
	}

}
