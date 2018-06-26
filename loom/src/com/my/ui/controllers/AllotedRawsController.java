package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.LoomRawService;
import com.my.ui.Controller;

public class AllotedRawsController implements Controller{

	private LoomRawService loomRawService;
	public AllotedRawsController(LoomRawService loomRawService)
	{
		this.loomRawService=loomRawService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("allot");
		List<Map<String, Object>> loomsRaws=loomRawService.loadLoomsRaws();
		request.setAttribute("loomsRaws", loomsRaws);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/loomRaws.jsp");
		rd.forward(request, response);
	}
	

}
