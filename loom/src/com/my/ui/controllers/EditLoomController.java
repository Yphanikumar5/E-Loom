package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.LoomService;
import com.my.service.dto.LoomDTO;
import com.my.ui.Controller;

public class EditLoomController implements Controller{
	private LoomService loomService;
	public EditLoomController(LoomService loomService)
	{
		this.loomService=loomService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lId=request.getParameter("lId");
		LoomDTO loom=loomService.load(new Integer(lId));
		request.setAttribute("loom", loom);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/EditLoom.jsp");
		rd.forward(request, response);
		
	}

}
