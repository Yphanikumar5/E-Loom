package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.MerchantPaymentDAO;
import com.my.dao.model.MerchantPaymentTL;
import com.my.ui.Controller;

public class MerchantPaymentsController implements Controller{
	
	private MerchantPaymentDAO merchantPaymentDAO;
	private Integer mpayId;
	
	public MerchantPaymentsController(MerchantPaymentDAO merchantPaymentDAO) {
		this.merchantPaymentDAO=merchantPaymentDAO;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<MerchantPaymentTL> merchantPayments=merchantPaymentDAO.getMerchantPayments(mpayId);
		request.setAttribute("merchantPayments", merchantPayments);
		RequestDispatcher rd=request.getRequestDispatcher("merchantPayments.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
