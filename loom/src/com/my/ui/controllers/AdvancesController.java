package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.AdvanceDAO;
import com.my.dao.model.AdvanceTL;
import com.my.service.AdvanceService;
import com.my.service.dto.AdvanceDTO;
import com.my.ui.Controller;

public class AdvancesController implements Controller{
	
	private AdvanceService advanceService;
	//private Integer empId;
	
	public AdvancesController(AdvanceService advanceService) {
		this.advanceService=advanceService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<AdvanceDTO> advances=advanceService.loadAdvances();
		request.setAttribute("advances", advances);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/advances.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
