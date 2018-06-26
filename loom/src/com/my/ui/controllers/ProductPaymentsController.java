package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ProductPaymentDAO;
import com.my.dao.model.ProductPaymentTL;
import com.my.ui.Controller;

public class ProductPaymentsController implements Controller{
	
	private ProductPaymentDAO productPaymentDAO;
	private Integer productPayId;
	
	public ProductPaymentsController(ProductPaymentDAO productPaymentDAO) {
		this.productPaymentDAO=productPaymentDAO;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductPaymentTL> productPayments=productPaymentDAO.getProductPayments(productPayId);
		request.setAttribute("productPayments", productPayments);
		RequestDispatcher rd=request.getRequestDispatcher("productPayments.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
