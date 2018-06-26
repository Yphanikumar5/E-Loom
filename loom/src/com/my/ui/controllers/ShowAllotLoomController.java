package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.EmpService;
import com.my.service.LoomService;
import com.my.service.dto.EmpDTO;
import com.my.service.dto.LoomDTO;
import com.my.ui.Controller;

public class ShowAllotLoomController implements Controller{
	private EmpService empService;
	private LoomService loomService;
	
	public ShowAllotLoomController(EmpService empService,LoomService loomService)
	{
		this.empService=empService;
		this.loomService=loomService;
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		List<EmpDTO> emps=empService.loadEmps();
		List<LoomDTO> looms=loomService.loadLooms();
		request.setAttribute("emps", emps);
		request.setAttribute("looms", looms);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/AddLoomEmp.jsp");
		rd.forward(request, response);
		
	}

}
