package com.my.dao;

import java.util.Map;

import com.my.dao.model.BillTL;

public interface BillDAO {
	public Integer insertBill(BillTL billTL);
	public Map<String, Object> getBillDetails(Integer billId);

}
