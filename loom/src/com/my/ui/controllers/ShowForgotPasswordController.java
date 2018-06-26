package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.ui.Controller;

public class ShowForgotPasswordController implements Controller{

	public void handleRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("Forgot.jsp");
		rd.forward(request,	response);
		
	}

}
