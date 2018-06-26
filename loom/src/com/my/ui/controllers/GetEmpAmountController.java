package com.my.ui.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.my.service.AdvanceService;
import com.my.ui.Controller;

public class GetEmpAmountController implements Controller{
	private AdvanceService advanceService;
	public GetEmpAmountController(AdvanceService advanceService)
	{
		this.advanceService=advanceService;
	}
	
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empId=request.getParameter("empId");
		Map<String, Object> amount=advanceService.loadEmpAmount(new Integer(empId));
		String result="{\"msg\":\"fail\"}";
		if(amount!=null)
		{
			ObjectMapper objectMapper=new ObjectMapper();
			result=objectMapper.writeValueAsString(amount);
		}
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		System.out.println(result);
		
	}

}
