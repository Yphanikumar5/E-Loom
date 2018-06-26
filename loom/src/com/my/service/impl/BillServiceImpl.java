package com.my.service.impl;

import java.util.List;
import java.util.Map;

import com.my.dao.BillDAO;
import com.my.dao.impl.BillDAOImpl;
import com.my.dao.model.BillTL;
import com.my.service.BillService;
import com.my.service.dto.BillDTO;

public class BillServiceImpl implements BillService{
	
	private BillDAO billDAO;
	public BillServiceImpl()
	{
		this.billDAO=new BillDAOImpl();
	}
	public Integer saveBill(BillDTO billDTO) {
		// TODO Auto-generated method stub
		Integer billId=null;
		BillTL billTL=new BillTL();
		billTL.setBillId(billDTO.getBillId());
		billTL.setCustomerId(billDTO.getCustomerId());
		billTL.setStatus(billDTO.getStatus());
		billTL.setCreatedBy(billDTO.getCreatedBy());
		billTL.setCreatedOn(new java.sql.Timestamp(billDTO.getCreatedOn().getTime()));
		billId=billDAO.insertBill(billTL);
		return billId;
	}
	public Map<String, Object> loadBillSetails(Integer billId) {
		
		// TODO Auto-generated method stub
		return  billDAO.getBillDetails(billId);
	}

}
