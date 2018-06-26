package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ProductReturnDAO;
import com.my.dao.model.ProductReturnTL;
import com.my.ui.forms.AddProductReturnForm;

public class AddProductReturnFormController extends AbstractFormController{
	
	private ProductReturnDAO productReturnDAO;
	
	public AddProductReturnFormController(ProductReturnDAO productReturnDAO) {
		this.productReturnDAO=productReturnDAO;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddProductReturnForm addProductReturnForm=(AddProductReturnForm)command;
		ProductReturnTL productReturnTL=new ProductReturnTL();
		
		
		productReturnTL.setProductId(addProductReturnForm.getProductId());
		productReturnTL.setCustomerId(addProductReturnForm.getCustomerId());
		productReturnTL.setQuantity(addProductReturnForm.getQuantity());
		productReturnTL.setSalesId(addProductReturnForm.getSalesId());
		productReturnTL.setStatus(addProductReturnForm.getStatus());
		
		productReturnDAO.insertProductReturn(productReturnTL);
		
		response.sendRedirect("users.htm");
		
		
		// TODO Auto-generated method stub
		
	}

}
