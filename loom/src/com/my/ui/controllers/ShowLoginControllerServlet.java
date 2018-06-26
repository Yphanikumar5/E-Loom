package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.service.AdminService;
import com.my.service.dto.AdminDTO;
import com.my.service.impl.AdminServiceImpl;

public class ShowLoginControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			try {
				String emailId = "";
				String password = "";
				String rem="rem";
				for (Cookie c : cookies) {
					if (c.getName().equalsIgnoreCase("loomusername")) {
						emailId = c.getValue();
						break;
					}
				}
				for (Cookie c : cookies) {
					if (c.getName().equalsIgnoreCase("loompassword")) {
						password = c.getValue();
						break;
					}
				}
				System.out.println(emailId+"uu "+password);
				AdminService adminService=new AdminServiceImpl();
				AdminDTO admin=adminService.loadAdmin(emailId, password);
				if(admin!=null)
				{
					if (rem != null) {

						Cookie cookie1 = new Cookie("loomusername",emailId);
						Cookie cookie2 = new Cookie("loompassword", password);
						cookie1.setMaxAge(100000);
						cookie2.setMaxAge(100000);
						response.addCookie(cookie1);
						response.addCookie(cookie2);
					}
					HttpSession session=request.getSession();
					session.setAttribute("admin", admin);
					response.sendRedirect("emps.htm");
				}
				else
				{
					request.setAttribute("msg", "invalid emailid password");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
