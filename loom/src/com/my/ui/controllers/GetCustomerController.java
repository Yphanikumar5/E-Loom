package com.my.ui.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.my.service.CustomerService;
import com.my.service.dto.CustomerDTO;
import com.my.ui.Controller;

public class GetCustomerController implements Controller{

	private CustomerService customerService;
	
	public GetCustomerController(CustomerService customerService) {
	
		this.customerService = customerService;
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		CustomerDTO customerDTO=customerService.load(new Integer(cid));
		String result="{\"msg\":\"fail\"}";
		if(customerDTO!=null)
		{
			ObjectMapper objectMapper=new ObjectMapper();
			result=objectMapper.writeValueAsString(customerDTO);
		}
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		System.out.println(result);
		
	}

}
