package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.CustomerPaymentDAO;
import com.my.dao.impl.CustomerPaymentDAOImpl;
import com.my.dao.model.CustomerPaymentTL;
import com.my.service.CustomerPaymentService;
import com.my.service.dto.CustomerPaymentDTO;

public class CustomerPaymentServiceImpl implements CustomerPaymentService
{
	private CustomerPaymentDAO customerPaymentDAO;
	public CustomerPaymentServiceImpl()
	{
		this.customerPaymentDAO=new CustomerPaymentDAOImpl();
	}

/*	public CustomerPaymentDTO load(Integer customerPayId) {
		// TODO Auto-generated method stub
		CustomerPaymentDTO customerPaymentDTO=null;
		CustomerPaymentTL customerPaymentTL=customerPaymentDAO.getCustomerPayment(customerPayId);
		if(customerPaymentTL!=null)
		{
			customerPaymentDTO=new CustomerPaymentDTO();
			customerPaymentDTO.setCustomerPayId(customerPaymentTL.getCustomerPayId());
			customerPaymentDTO.setCustomerId(customerPaymentTL.getCustomerId());
			customerPaymentDTO.setAmount(customerPaymentTL.getAmount());
			customerPaymentDTO.setStatus(customerPaymentTL.getStatus());
			customerPaymentDTO.setCreatedBy(customerPaymentTL.getCreatedBy());
			customerPaymentDTO.setCreatedOn(customerPaymentTL.getCreatedOn());
		}
		
		
		return customerPaymentDTO;
	}

	public List<CustomerPaymentDTO> loadCustomerPayments() {
		// TODO Auto-generated method stub
		List<CustomerPaymentDTO> customerPayments=null;
		List<CustomerPaymentTL> custPay=customerPaymentDAO.getCustomerPayments();
		if(custPay!=null)
		{
			customerPayments=new ArrayList();
			ListIterator<CustomerPaymentTL> li=custPay.listIterator();
			while(li.hasNext())
			{
				CustomerPaymentDTO customerPaymentDTO=new CustomerPaymentDTO();
				CustomerPaymentTL customerPaymentTL=li.next();
				customerPaymentDTO.setCustomerPayId(customerPaymentTL.getCustomerPayId());
				customerPaymentDTO.setCustomerId(customerPaymentTL.getCustomerId());
				customerPaymentDTO.setAmount(customerPaymentTL.getAmount());
				customerPaymentDTO.setStatus(customerPaymentTL.getStatus());
				customerPaymentDTO.setCreatedBy(customerPaymentTL.getCreatedBy());
				customerPaymentDTO.setCreatedOn(customerPaymentTL.getCreatedOn());
				customerPayments.add(customerPaymentDTO);
			}
		}
		
		return customerPayments;
	}

	public void modify(CustomerPaymentDTO customerPaymentDTO) {
		
		// TODO Auto-generated method stub
	
		CustomerPaymentTL customerPaymentTL=new CustomerPaymentTL();
		customerPaymentTL.setAmount(customerPaymentDTO.getAmount());
		customerPaymentDAO.updateCustomerPayment(customerPaymentTL);
	}
*/
	public Integer saveCustomerPayment(CustomerPaymentDTO customerPaymentDTO) {
		// TODO Auto-generated method stub
		Integer customerPayId=0;
		
		CustomerPaymentTL customerPaymentTL=new CustomerPaymentTL();
		customerPaymentTL.setCustomerPayId(customerPaymentDTO.getCustomerPayId());
		customerPaymentTL.setCustomerId(customerPaymentDTO.getCustomerId());
		customerPaymentTL.setBillId(customerPaymentDTO.getBillId());
		customerPaymentTL.setPaidAmount(customerPaymentDTO.getPaidAmount());
		customerPaymentTL.setStatus(customerPaymentDTO.getStatus());
		customerPaymentTL.setCreatedBy(customerPaymentDTO.getCreatedBy());
		customerPaymentTL.setCreatedOn(new java.sql.Timestamp(customerPaymentDTO.getCreatedOn().getTime()));
		customerPayId=customerPaymentDAO.insertCustomerPayment(customerPaymentTL);
	     return customerPayId;
	}

}
