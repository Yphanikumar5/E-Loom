package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.service.AdminService;
import com.my.service.dto.AdminDTO;
import com.my.ui.Controller;
import com.my.utility.MailService;



public class ForgotFormController implements Controller{
	private AdminService userService;
	private MailService mailService=new MailService();
	public ForgotFormController(AdminService userService) {
		this.userService=userService;
		
	}
	public void handleRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
	
		AdminDTO user=userService.loadAdmin(request.getParameter("emailId"));
		
		if(user!=null){
			try {
				mailService.send(user.getEmailId(), "Password", user.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("showlogin");
		}
		else {
			//here request is a requestscope
			request.setAttribute("msg", "Invalid user");
			//requestDispather is used for forwarding a request
			RequestDispatcher rd=request.getRequestDispatcher("Forgot.jsp");
			rd.forward(request, response);
		}	
	}
}
