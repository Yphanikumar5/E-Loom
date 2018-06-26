package com.my.ui.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.MerchantDAO;
import com.my.dao.model.MerchantTL;
import com.my.ui.Controller;

public class MerchantsController implements Controller{
	
	private MerchantDAO merchantDAO;
	private Integer merchantId;
	
	public MerchantsController(MerchantDAO merchantDAO) {
		this.merchantDAO=merchantDAO;
		// TODO Auto-generated constructor stub
	}

	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<MerchantTL> merchants=merchantDAO.getMerchants(merchantId);
		request.setAttribute("merchants", merchants);
		RequestDispatcher rd=request.getRequestDispatcher("merchants.jsp");
		rd.forward(request, response);
		
		
		
		// TODO Auto-generated method stub
		
	}

}
