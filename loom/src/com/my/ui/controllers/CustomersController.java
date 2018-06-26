package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.CustomerDAO;
import com.my.dao.model.CustomerTL;
import com.my.service.CustomerService;
import com.my.service.dto.CustomerDTO;
import com.my.ui.Controller;

public class CustomersController implements Controller{
	private CustomerService customerService;
	//private Integer customerId;
	
	public CustomersController(CustomerService customerService) {
		this.customerService=customerService;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<CustomerDTO> customers=customerService.loadCustomers();
		request.setAttribute("customers", customers);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/customers.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
