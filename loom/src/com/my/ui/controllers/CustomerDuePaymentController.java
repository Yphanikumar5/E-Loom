package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.service.CustomerPaymentService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.CustomerPaymentDTO;
import com.my.ui.Controller;

public class CustomerDuePaymentController implements Controller{
	private CustomerPaymentService CustomerPaymentService;
	public CustomerDuePaymentController(CustomerPaymentService customerPaymentService)
	{
		this.CustomerPaymentService=customerPaymentService;
		
	}
	

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String billId=request.getParameter("billId");
		String customerId=request.getParameter("customerId");
		String payAmount=request.getParameter("payAmount");
		CustomerPaymentDTO customerPaymentDTO=new CustomerPaymentDTO();
		customerPaymentDTO.setBillId(new Integer(billId));
		customerPaymentDTO.setCustomerId(new Integer(customerId));
		customerPaymentDTO.setStatus("Paid");
		customerPaymentDTO.setCreatedOn(new java.util.Date());
		customerPaymentDTO.setPaidAmount(new Double(payAmount));
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		customerPaymentDTO.setCreatedBy(admin.getAdminId());
		CustomerPaymentService.saveCustomerPayment(customerPaymentDTO);
		response.sendRedirect("showbill.htm");
	}

}
