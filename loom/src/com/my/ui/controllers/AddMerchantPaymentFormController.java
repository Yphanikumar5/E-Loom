package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.MerchantPaymentDAO;
import com.my.dao.model.MerchantPaymentTL;
import com.my.ui.forms.AddMerchantForm;
import com.my.ui.forms.AddMerchantPaymentForm;

public class AddMerchantPaymentFormController extends AbstractFormController{
	
	private MerchantPaymentDAO merchantPaymentDAO;
	public AddMerchantPaymentFormController(MerchantPaymentDAO merchantPaymentDAO) {
		this.merchantPaymentDAO=merchantPaymentDAO;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddMerchantPaymentForm addMerchantPaymentForm=(AddMerchantPaymentForm)command;
		MerchantPaymentTL merchantPaymentTL=new MerchantPaymentTL();
		
		merchantPaymentTL.setPaymentId(addMerchantPaymentForm.getPaymentId());
		merchantPaymentTL.setAmount(addMerchantPaymentForm.getAmount());
		merchantPaymentTL.setStatus(addMerchantPaymentForm.getStatus());
		
		merchantPaymentDAO.insertMerchantPayment(merchantPaymentTL);
		
		response.sendRedirect("users.htm");
		
		
		// TODO Auto-generated method stub
		
	}
	

}
