package com.my.dao;

import java.util.List;

import com.my.dao.model.MerchantTL;

public interface MerchantDAO {
	public Integer insertMerchant(MerchantTL merchantTL);
	public MerchantTL getMerchant(Integer merchantId);
	public void updateMerchant(MerchantTL merchantTL);
	public List<MerchantTL> getMerchants();

}
