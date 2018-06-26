package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.LoomService;
import com.my.service.RawService;
import com.my.service.dto.LoomDTO;
import com.my.service.dto.RawDTO;
import com.my.ui.Controller;

public class ShowAllotRawsController implements Controller{

	private LoomService loomService;
	private RawService rawService;
	public ShowAllotRawsController(LoomService loomService,RawService rawService)
	{
		this.loomService=loomService;
		this.rawService=rawService;
		
	}
	
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<LoomDTO> looms=loomService.loadLooms();
		List<RawDTO> raws=rawService.loadRaws();
		request.setAttribute("looms", looms);
		request.setAttribute("raws", raws);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/AddLoomRaw.jsp");
		rd.forward(request, response);
	}

}
