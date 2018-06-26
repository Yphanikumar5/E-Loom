package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ProductReturnDAO;
import com.my.dao.model.ProductReturnTL;
import com.my.ui.Controller;

public class ProductReturnsController implements Controller{
	
	private ProductReturnDAO productReturnDAO;
	private Integer customerId;
	
	public ProductReturnsController(ProductReturnDAO productReturnDAO) {
		this.productReturnDAO=productReturnDAO;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ProductReturnTL> productReturns=productReturnDAO.getProductReturns(customerId);
		request.setAttribute("productReturns", productReturns);
		RequestDispatcher rd=request.getRequestDispatcher("productReturns.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
