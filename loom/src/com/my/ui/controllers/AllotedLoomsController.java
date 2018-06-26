package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.LoomEmpService;
import com.my.ui.Controller;

public class AllotedLoomsController implements Controller{

	private LoomEmpService loomEmpService;
	public AllotedLoomsController(LoomEmpService loomEmpService)
	{
		this.loomEmpService=loomEmpService;
	}
	
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> loomsEmps=loomEmpService.loadLoomsEmps();
		
		request.setAttribute("loomsEmps", loomsEmps);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/loomEmps.jsp");
		rd.forward(request, response);
		
	}
	

}
