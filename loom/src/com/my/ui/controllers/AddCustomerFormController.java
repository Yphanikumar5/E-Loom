package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.CustomerDAO;
import com.my.dao.model.CustomerTL;
import com.my.service.CustomerService;
import com.my.service.dto.CustomerDTO;
import com.my.ui.forms.AddCustomerForm;

public class AddCustomerFormController extends AbstractFormController{
	
	private CustomerService customerService;
	
	public AddCustomerFormController(CustomerService customerService)
	{
		this.customerService=customerService;
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		  AddCustomerForm addCustomerForm=(AddCustomerForm)command;
		  
		  CustomerDTO customerDTO=new CustomerDTO();
		  customerDTO.setCustomerId(addCustomerForm.getCustomerId());
		  customerDTO.setCustomerName(addCustomerForm.getCustomerName());
		  customerDTO.setCustomerPhoto(addCustomerForm.getCustomerPhoto());
		  customerDTO.setCustomerType(addCustomerForm.getCustomerType());
		  customerDTO.setAddress(addCustomerForm.getAddress());
		  customerDTO.setMobileNumber(addCustomerForm.getMobileNumber());
		  customerDTO.setAadharNumber(addCustomerForm.getAadharNumber());
		  customerDTO.setStatus(addCustomerForm.getStatus());
		  
		  customerService.saveCustomer(customerDTO);
		  response.sendRedirect("customers.htm");
		
	}

}
