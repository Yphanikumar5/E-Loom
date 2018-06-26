
package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.CustomerDAO;
import com.my.dao.impl.CustomerDAOImpl;
import com.my.dao.model.CustomerTL;
import com.my.service.CustomerService;
import com.my.service.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl()
	{
		this.customerDAO=new CustomerDAOImpl();
	}
	
	public CustomerDTO load(Integer customerId) {
		// TODO Auto-generated method stub
		CustomerDTO customerDTO=null;
		CustomerTL customerTL=customerDAO.getCustomer(customerId);
		if(customerTL!=null)
		{
			customerDTO=new CustomerDTO();
			customerDTO.setCustomerId(customerTL.getCustomerId());
			customerDTO.setCustomerName(customerTL.getCustomerName());
			customerDTO.setCustomerPhoto(customerTL.getCustomerPhoto());
			customerDTO.setAddress(customerTL.getAddress());
			customerDTO.setMobileNumber(customerTL.getMobileNumber());
			customerDTO.setAadharNumber(customerTL.getAadharNumber());
			customerDTO.setCustomerType(customerTL.getCustomerType());
			customerDTO.setStatus(customerTL.getStatus());
			customerDTO.setCreatedBy(customerTL.getCreatedBy());
			customerDTO.setCreatedOn(customerTL.getCreatedOn());
			
			
		}
		
		return customerDTO;
	}

	public List<CustomerDTO> loadCustomers() {
		// TODO Auto-generated method stub
		List<CustomerDTO> customers=null;
		List<CustomerTL> cust=customerDAO.getCustomers();
		if(cust!=null)
		{
			customers=new ArrayList();
			ListIterator<CustomerTL> li=cust.listIterator();
			while(li.hasNext())
			{
				CustomerDTO customerDTO=new CustomerDTO();
				CustomerTL customerTL=li.next();
				customerDTO.setCustomerId(customerTL.getCustomerId());
				customerDTO.setCustomerName(customerTL.getCustomerName());
				customerDTO.setCustomerPhoto(customerTL.getCustomerPhoto());
				customerDTO.setAddress(customerTL.getAddress());
				customerDTO.setMobileNumber(customerTL.getMobileNumber());
				customerDTO.setAadharNumber(customerTL.getAadharNumber());
				customerDTO.setCustomerType(customerTL.getCustomerType());
				customerDTO.setStatus(customerTL.getStatus());
				customerDTO.setCreatedBy(customerTL.getCreatedBy());
				customerDTO.setCreatedOn(customerTL.getCreatedOn());
				customers.add(customerDTO);
			}
		}
		
		return customers;
	}

	public void modify(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		CustomerTL customerTL=new CustomerTL();
		customerTL.setCustomerName(customerDTO.getCustomerName());
		customerTL.setCustomerPhoto(customerDTO.getCustomerPhoto());
		customerTL.setAddress(customerDTO.getAddress());
		customerTL.setMobileNumber(customerDTO.getMobileNumber());
		customerTL.setAadharNumber(customerDTO.getAadharNumber());
		customerTL.setCustomerType(customerDTO.getCustomerType());
		customerDAO.updateCustomer(customerTL);
	}

	public Integer saveCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Integer customerId=0;
		CustomerTL customerTL=new CustomerTL();
		customerTL.setCustomerName(customerDTO.getCustomerName());
		customerTL.setCustomerPhoto(customerDTO.getCustomerPhoto());
		customerTL.setCustomerType(customerDTO.getCustomerType());
		customerTL.setAddress(customerDTO.getAddress());
		customerTL.setMobileNumber(customerDTO.getMobileNumber());
		customerTL.setAadharNumber(customerDTO.getAadharNumber());
		customerTL.setCreatedOn(new java.sql.Timestamp(customerDTO.getCreatedOn().getTime()));
		customerTL.setCreatedBy(customerDTO.getCreatedBy());
		
		
		customerId=customerDAO.insertCustomer(customerTL);
		
		return customerId;
	}

}
