package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.BillService;
import com.my.ui.Controller;

public class ShowAddBillController implements Controller{
	private BillService billService;
	public ShowAddBillController(BillService billService)
	{
		this.billService=billService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Pages/AddBill.jsp");
		rd.forward(request, response);
		
	}

}
