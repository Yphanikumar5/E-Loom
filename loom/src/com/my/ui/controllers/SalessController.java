package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.SalesDAO;
import com.my.dao.model.SalesTL;
import com.my.ui.Controller;

public class SalessController implements Controller{
	
	private SalesDAO salesDAO;
	private Integer customerId;
	
	public SalessController(SalesDAO salesDAO) {
		this.salesDAO=salesDAO;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<SalesTL> saless=salesDAO.getSaless(customerId);
		request.setAttribute("saless", saless);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/saless.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
