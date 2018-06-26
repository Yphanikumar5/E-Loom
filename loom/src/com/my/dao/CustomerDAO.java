package com.my.dao;

import java.util.List;

import com.my.dao.model.CustomerTL;

public interface CustomerDAO {
	public Integer insertCustomer(CustomerTL customerTL);
	public CustomerTL getCustomer(Integer customerId);
	public void updateCustomer(CustomerTL customerTL);
	public List<CustomerTL> getCustomers();


}
