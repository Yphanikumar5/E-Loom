package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.CustomerPaymentDAO;
import com.my.dao.model.CustomerPaymentTL;
import com.my.ui.Controller;

public class CustomerPaymentsController implements Controller{
	private CustomerPaymentDAO customerPaymentDAO;
	//private Integer customerId;
	
	public CustomerPaymentsController(CustomerPaymentDAO customerPaymentDAO) {
		this.customerPaymentDAO=customerPaymentDAO;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<CustomerPaymentTL> customerPayments=customerPaymentDAO.getCustomerPayments();
		request.setAttribute("customerPayments", customerPayments);
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/customerPayments.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
