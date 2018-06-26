package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ProductPaymentDAO;
import com.my.dao.model.ProductPaymentTL;
import com.my.ui.forms.AddProductPaymentForm;
import com.my.ui.forms.AddSalesForm;

public class AddProductPaymentFormController extends AbstractFormController{

	
	private ProductPaymentDAO productPaymentDAO;
	public AddProductPaymentFormController(ProductPaymentDAO productPaymentDAO) {
		this.productPaymentDAO=productPaymentDAO;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddProductPaymentForm addProductPaymentForm=(AddProductPaymentForm)command;
		
		ProductPaymentTL productPaymentTL=new ProductPaymentTL();
		
		productPaymentTL.setProductType(addProductPaymentForm.getProductType());
		productPaymentTL.setAmount(addProductPaymentForm.getAmount());
		productPaymentTL.setStatus(addProductPaymentForm.getStatus());
		
		productPaymentDAO.insertProductPayment(productPaymentTL);
		
		response.sendRedirect("users.htm");
		
		
		
		// TODO Auto-generated method stub
		
	}
	
}
