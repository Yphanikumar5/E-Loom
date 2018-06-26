package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.RawService;
import com.my.service.dto.RawDTO;
import com.my.ui.Controller;

public class EditRawController implements Controller{
	private RawService rawService;
	public EditRawController(RawService rawService)
	{
		this.rawService=rawService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rId=request.getParameter("rId");
		RawDTO raw=rawService.load(new Integer(rId));
		request.setAttribute("raw", raw);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/EditRaw.jsp");
		rd.forward(request, response);
	}

}
