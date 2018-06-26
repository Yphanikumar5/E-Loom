package com.my.service;

import java.util.List;
import java.util.Map;

import com.my.service.dto.BillDTO;

public interface BillService {
	public Integer saveBill(BillDTO billDTO	);
	public Map<String, Object>  loadBillSetails(Integer billId);

}
