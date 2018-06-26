package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.RawDAO;
import com.my.dao.model.RawTL;
import com.my.service.RawService;
import com.my.service.dto.RawDTO;
import com.my.ui.Controller;

public class RawsController implements Controller{
	
	private RawService rawService;
	//private Integer merchantId;
	
	public RawsController(RawService rawService) {
		this.rawService=rawService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<RawDTO> raws=rawService.loadRaws();
		request.setAttribute("raws", raws);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/raws.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
