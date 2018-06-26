package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.SalesDAO;
import com.my.dao.model.SalesTL;
import com.my.service.SalesService;
import com.my.service.dto.SalesDTO;
import com.my.ui.forms.AddSalesForm;

public class AddSalesFormController extends AbstractFormController{
	
	private SalesService salesService;
	
	public AddSalesFormController(SalesService salesService) {
		this.salesService=salesService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddSalesForm addSalesForm=(AddSalesForm)command;
		SalesDTO salesDTO=new SalesDTO();
		salesDTO.setSalesId(addSalesForm.getSalesId());
		salesDTO.setBillId(addSalesForm.getBillId());
		salesDTO.setProductType(addSalesForm.getProductType());
		salesDTO.setQuantity(addSalesForm.getQuantity());
		salesDTO.setPrice(addSalesForm.getPrice());
		
		
		response.sendRedirect("saless.htm");
		
		
		// TODO Auto-generated method stub
		
	}

}
