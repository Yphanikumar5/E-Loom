package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.LoomEmpDAO;
import com.my.dao.model.LoomEmpTL;
import com.my.service.LoomEmpService;
import com.my.service.dto.LoomEmpDTO;
import com.my.ui.Controller;

public class LoomEmpsController implements Controller{

	
	private LoomEmpService loomEmpService;
//	private Integer empId;
	
	public LoomEmpsController(LoomEmpService loomEmpService) {
		this.loomEmpService=loomEmpService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<LoomEmpDTO> loomEmps=loomEmpService.loadLoomEmps();
		request.setAttribute("loomEmps", loomEmps);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/loomEmps.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}
}
