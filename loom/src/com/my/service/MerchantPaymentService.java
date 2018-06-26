package com.my.service;

import java.util.List;

import com.my.service.dto.MerchantPaymentDTO;

public interface MerchantPaymentService {
	
	public Integer saveMerchantPayment(MerchantPaymentDTO merchantPaymentDTO);
	public MerchantPaymentDTO load(Integer mpayId);
	public void modify(MerchantPaymentDTO merchantPaymentDTO);
	public List<MerchantPaymentDTO> loadMerchantPayments();
}
