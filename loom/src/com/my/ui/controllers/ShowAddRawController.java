package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.RawService;
import com.my.ui.Controller;

public class ShowAddRawController implements Controller{
	private RawService rawService;
	public ShowAddRawController(RawService rawService) {
		this.rawService=rawService;
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/AddRaw.jsp");
		rd.forward(request, response);
	}

}
