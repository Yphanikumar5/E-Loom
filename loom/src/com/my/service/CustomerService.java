package com.my.service;

import java.util.List;

import com.my.service.dto.CustomerDTO;

public interface CustomerService {
	
	public Integer saveCustomer(CustomerDTO customerDTO);
	public CustomerDTO load(Integer customerId);
	public void modify(CustomerDTO customerDTO);
	public List<CustomerDTO> loadCustomers();

}
