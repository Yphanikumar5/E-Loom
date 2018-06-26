package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.LoomService;
import com.my.service.dto.LoomDTO;
import com.my.ui.Controller;

public class LoomsController implements Controller{
	
	private LoomService loomService;
	//private Integer loomId;
	
	public LoomsController(LoomService loomService) {
		this.loomService=loomService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<LoomDTO> looms=loomService.loadLooms();
		request.setAttribute("looms", looms);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/looms.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
