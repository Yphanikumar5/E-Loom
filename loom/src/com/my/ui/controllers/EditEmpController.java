package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.EmpService;
import com.my.service.dto.EmpDTO;
import com.my.ui.Controller;

public class EditEmpController implements Controller{
	private EmpService empService;
	public EditEmpController (EmpService empService)
	{
		this.empService=empService;
	}
	

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid=request.getParameter("eid");
		EmpDTO emp=empService.load(new Integer(eid));
		request.setAttribute("emp", emp);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/EditEmp.jsp");
		rd.forward(request, response);
	}

}
