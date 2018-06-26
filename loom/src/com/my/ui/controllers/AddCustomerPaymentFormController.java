package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.CustomerPaymentDAO;
import com.my.dao.model.CustomerPaymentTL;
import com.my.service.CustomerPaymentService;
import com.my.service.dto.CustomerPaymentDTO;
import com.my.ui.forms.AddCustomerPaymentForm;

public class AddCustomerPaymentFormController extends AbstractFormController{
	private CustomerPaymentService customerPaymentService;
	
	public AddCustomerPaymentFormController(CustomerPaymentService customerPaymentService) {
		this.customerPaymentService=customerPaymentService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddCustomerPaymentForm addCustomerPaymentForm=(AddCustomerPaymentForm)command;
		
		CustomerPaymentDTO customerPaymentDTO=new CustomerPaymentDTO();
		customerPaymentDTO.setCustomerPayId(addCustomerPaymentForm.getCustomerPayId());
		customerPaymentDTO.setCustomerId(addCustomerPaymentForm.getCustomerId());
		customerPaymentDTO.setBillId(addCustomerPaymentForm.getBillId());
		customerPaymentDTO.setPaidAmount(addCustomerPaymentForm.getPaidAmount());
		customerPaymentDTO.setStatus(addCustomerPaymentForm.getStatus());
		customerPaymentService.saveCustomerPayment(customerPaymentDTO);
		response.sendRedirect("showbill.htm");
		
		
	
		
		
	
		
	}
	

}
