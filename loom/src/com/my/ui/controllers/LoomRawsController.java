package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.LoomRawDAO;
import com.my.dao.model.LoomRawTL;
import com.my.service.LoomRawService;
import com.my.service.dto.LoomRawDTO;
import com.my.ui.Controller;

public class LoomRawsController implements Controller{
	
	private LoomRawService loomRawService;
	//private Integer loomId;
	
	public LoomRawsController(LoomRawService loomRawService) {
		this.loomRawService=loomRawService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<LoomRawDTO> loomRaws=loomRawService.loadLoomRaws();
		request.setAttribute("loomRaws", loomRaws);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/loomRaws.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
