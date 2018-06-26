package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.CustomerService;
import com.my.service.dto.CustomerDTO;
import com.my.ui.Controller;

public class EditCustomerController implements Controller{
	private CustomerService customerService;
	public EditCustomerController(CustomerService customerService)
	{
		this.customerService=customerService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cId=request.getParameter("cId");
		CustomerDTO customer=customerService.load(new Integer(cId));
		request.setAttribute("customer", customer);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/EditCustomer.jsp");
		rd.forward(request, response);
	}

}
