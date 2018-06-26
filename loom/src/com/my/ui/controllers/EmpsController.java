package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.EmpDAO;
import com.my.dao.model.EmpTL;
import com.my.service.EmpService;
import com.my.service.dto.EmpDTO;
import com.my.ui.Controller;

public class EmpsController implements Controller{
	
	private EmpService empService;
	//private Integer empId;
	
	public EmpsController(EmpService empService) {
		this.empService=empService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<EmpDTO> emps=empService.loadEmps();
		request.setAttribute("emps", emps);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/emps.jsp");
		rd.forward(request, response);
	}
	

}
