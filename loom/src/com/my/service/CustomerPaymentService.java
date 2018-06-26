package com.my.service;

import java.util.List;


import com.my.service.dto.CustomerPaymentDTO;

public interface CustomerPaymentService {
	
	public Integer saveCustomerPayment(CustomerPaymentDTO customerPaymentDTO);
	//public CustomerPaymentDTO load(Integer customerPayId);
	//public void modify(CustomerPaymentDTO customerPaymentDTO);
	//public List<CustomerPaymentDTO> loadCustomerPayments();

}
