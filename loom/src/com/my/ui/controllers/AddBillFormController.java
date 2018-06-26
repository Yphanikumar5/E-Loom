package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.service.BillService;
import com.my.service.CustomerPaymentService;
import com.my.service.CustomerService;
import com.my.service.SalesService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.BillDTO;
import com.my.service.dto.CustomerDTO;
import com.my.service.dto.CustomerPaymentDTO;
import com.my.service.dto.SalesDTO;
import com.my.ui.forms.AddBillForm;

public class AddBillFormController extends AbstractFormController{
	private CustomerService customerService;
	private BillService billService;
	private SalesService salesService;
	private CustomerPaymentService customerPaymentService;
	public AddBillFormController(CustomerService customerService,BillService billService,SalesService salesService,CustomerPaymentService customerPaymentService)
	{
		this.customerService=customerService;
		this.billService=billService;
		this.salesService=salesService;
		this.customerPaymentService=customerPaymentService;
	}
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddBillForm addBillForm=(AddBillForm)command;
		Integer customerId=addBillForm.getCustomerId();
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		if(customerId==null)
		{
			CustomerDTO customerDTO=new CustomerDTO();
			customerDTO.setCustomerId(addBillForm.getCustomerId());
			//customerDTO.setCustomerName(addBillForm.getCustomerName());
			customerDTO.setCustomerName(addBillForm.getCustomerName());
			customerDTO.setCustomerPhoto(addBillForm.getCustomerPhoto());
			customerDTO.setCustomerType(addBillForm.getCustomerType());
			customerDTO.setAddress(addBillForm.getAddress());
			customerDTO.setMobileNumber(addBillForm.getMobileNumber());
			customerDTO.setAadharNumber(addBillForm.getAadharNumber());
			customerDTO.setCreatedOn(new java.util.Date());
		
			
			customerDTO.setCreatedBy(admin.getAdminId());
			
			customerId=customerService.saveCustomer(customerDTO);
		}
		BillDTO billDTO=new BillDTO();
		billDTO.setCustomerId(customerId);
		billDTO.setCreatedOn(new java.util.Date());
		billDTO.setCreatedBy(admin.getAdminId());
		billDTO.setStatus("paid");
		
		Integer billId=billService.saveBill(billDTO);
		if(addBillForm.getProductType()!=null&&addBillForm.getProductType().length>0)
		{
			for(int index=0;index<addBillForm.getProductType().length;index++)
			{
				SalesDTO salesDTO=new SalesDTO();
				salesDTO.setSalesId(addBillForm.getSalesId());
				salesDTO.setBillId(billId);
				salesDTO.setProductType(addBillForm.getProductType()[index]);
				salesDTO.setQuantity(addBillForm.getQuantity()[index]);
				salesDTO.setPrice(addBillForm.getPrice()[index]);
				salesDTO.setDiscount(addBillForm.getDiscount()[index]);
				salesDTO.setCreatedOn(new java.util.Date());
			
				salesDTO.setCreatedBy(admin.getAdminId());
				
				salesService.saveSales(salesDTO);
			}
		}
		CustomerPaymentDTO customerPaymentDTO=new CustomerPaymentDTO();
		customerPaymentDTO.setCustomerPayId(addBillForm.getCustomerPayId());
		customerPaymentDTO.setCustomerId(customerId);
		customerPaymentDTO.setBillId(billId);
		customerPaymentDTO.setPaidAmount(addBillForm.getPaidAmount());
		customerPaymentDTO.setCreatedOn(new java.util.Date());
		//HttpSession session=request.getSession(false);
		//AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		customerPaymentDTO.setCreatedBy(admin.getAdminId());
				customerPaymentService.saveCustomerPayment(customerPaymentDTO);
		response.sendRedirect("bill.htm");
		
		// TODO Auto-generated method stub
		
	}

}

