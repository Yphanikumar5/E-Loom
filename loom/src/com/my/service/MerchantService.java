package com.my.service;

import java.util.List;

import com.my.service.dto.MerchantDTO;

public interface MerchantService{
	public Integer saveMerchant(MerchantDTO merchantDTO);
	public MerchantDTO load(Integer merchantId);
	public void modify(MerchantDTO merchantDTO);
	public List<MerchantDTO> loadMerchants();

}
