package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.MerchantDAO;
import com.my.dao.model.MerchantTL;
import com.my.ui.forms.AddMerchantForm;

public class AddMerchantFormController extends AbstractFormController{
	private  MerchantDAO merchantDAO;
	
	public AddMerchantFormController(MerchantDAO merchantDAO) {
		this.merchantDAO=merchantDAO;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddMerchantForm addMerchantForm=(AddMerchantForm)command;
		
		MerchantTL merchantTL=new MerchantTL();
		
		merchantTL.setMerchantName(addMerchantForm.getMerchantName());
		merchantTL.setMerchantPhoto(addMerchantForm.getMerchantPhoto());
		merchantTL.setMobileNumber(addMerchantForm.getMobileNumber());
		merchantTL.setAddress(addMerchantForm.getAddress());
		merchantTL.setAccountNumber(addMerchantForm.getAccountNumber());
		merchantTL.setIfscCode(addMerchantForm.getIfscCode());
		merchantTL.setBankName(addMerchantForm.getBankName());
		merchantTL.setStatus(addMerchantForm.getStatus());
		
		
		merchantDAO.insertMerchant(merchantTL);
		
		response.sendRedirect("users.htm");
		
		
		
		// TODO Auto-generated method stub
		
	}

}
