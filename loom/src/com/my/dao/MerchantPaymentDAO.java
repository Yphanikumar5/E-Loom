package com.my.dao;

import java.util.List;

import com.my.dao.model.MerchantPaymentTL;

public interface MerchantPaymentDAO {
	public Integer insertMerchantPayment(MerchantPaymentTL merchantPaymentTL);
	public MerchantPaymentTL getMerchantPayment(Integer mayId);
	public void updateMerchantPayment(MerchantPaymentTL merchantPaymentTL);
	public List<MerchantPaymentTL> getMerchantPayments();


}
