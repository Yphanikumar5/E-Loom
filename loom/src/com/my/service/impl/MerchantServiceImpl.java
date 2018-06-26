package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.MerchantDAO;
import com.my.dao.impl.MerchantDAOImpl;
import com.my.dao.model.MerchantTL;
import com.my.service.MerchantService;
import com.my.service.dto.MerchantDTO;

public class MerchantServiceImpl implements MerchantService{
	
	private MerchantDAO merchantDAO;
	public MerchantServiceImpl()
	{
		this.merchantDAO=new MerchantDAOImpl();
	}
	
	
	public MerchantDTO load(Integer merchantId) {
		// TODO Auto-generated method stub
		MerchantDTO merchantDTO=null;
		MerchantTL merchantTL=merchantDAO.getMerchant(merchantId);
		if(merchantTL!=null)
		{
			merchantDTO=new MerchantDTO();
			merchantDTO.setMerchantId(merchantTL.getMerchantId());
			merchantDTO.setMerchantName(merchantTL.getMerchantName());
			merchantDTO.setMerchantPhoto(merchantTL.getMerchantPhoto());
			merchantDTO.setMobileNumber(merchantTL.getMobileNumber());
			merchantDTO.setAddress(merchantTL.getAddress());
			merchantDTO.setAccountNumber(merchantTL.getAccountNumber());
			merchantDTO.setIfscCode(merchantTL.getIfscCode());
			merchantDTO.setBankName(merchantTL.getBankName());
			merchantDTO.setStatus(merchantTL.getStatus());
			merchantDTO.setCreatedBy(merchantTL.getCreatedBy());
			merchantDTO.setCreatedOn(merchantTL.getCreatedOn());
		}
		
		return merchantDTO;
	}

	public List<MerchantDTO> loadMerchants() {
		// TODO Auto-generated method stub
		
		List<MerchantDTO> merchants=null;
		List<MerchantTL> mer=merchantDAO.getMerchants();
		if(mer!=null)
		{
			merchants=new ArrayList();
			ListIterator<MerchantTL> li=mer.listIterator();
			while(li.hasNext())
			{
				MerchantDTO merchantDTO=new MerchantDTO();
				MerchantTL merchantTL=li.next();
				merchantDTO.setMerchantId(merchantTL.getMerchantId());
				merchantDTO.setMerchantName(merchantTL.getMerchantName());
				merchantDTO.setMerchantPhoto(merchantTL.getMerchantPhoto());
				merchantDTO.setMobileNumber(merchantTL.getMobileNumber());
				merchantDTO.setAddress(merchantTL.getAddress());
				merchantDTO.setAccountNumber(merchantTL.getAccountNumber());
				merchantDTO.setIfscCode(merchantTL.getIfscCode());
				merchantDTO.setBankName(merchantTL.getBankName());
				merchantDTO.setStatus(merchantTL.getStatus());
				merchantDTO.setCreatedBy(merchantTL.getCreatedBy());
				merchantDTO.setCreatedOn(merchantTL.getCreatedOn());
				merchants.add(merchantDTO);
			}
			
			
		}
		
		return merchants;
	}

	
	public Integer saveMerchant(MerchantDTO merchantDTO) {
		// TODO Auto-generated method stub
		Integer merchantId=0;
		MerchantTL merchantTL=new MerchantTL();
		merchantTL.setMerchantName(merchantDTO.getMerchantName());
		merchantTL.setMerchantPhoto(merchantDTO.getMerchantPhoto());
		merchantTL.setMobileNumber(merchantDTO.getMobileNumber());
		merchantTL.setAddress(merchantDTO.getAddress());
		merchantTL.setAccountNumber(merchantDTO.getAccountNumber());
		merchantTL.setIfscCode(merchantDTO.getIfscCode());
		merchantTL.setBankName(merchantDTO.getBankName());
		merchantId=merchantDAO.insertMerchant(merchantTL);
		
		return merchantId;
	}


	public void modify(MerchantDTO merchantDTO) {
		// TODO Auto-generated method stub
		MerchantTL merchantTL=new MerchantTL();
		merchantTL.setMerchantName(merchantDTO.getMerchantName());
		merchantTL.setMerchantPhoto(merchantDTO.getMerchantPhoto());
		merchantTL.setMobileNumber(merchantDTO.getMobileNumber());
		merchantTL.setAddress(merchantDTO.getAddress());
		merchantTL.setAccountNumber(merchantDTO.getAccountNumber());
		merchantTL.setIfscCode(merchantDTO.getIfscCode());
		merchantTL.setBankName(merchantDTO.getBankName());
		merchantDAO.updateMerchant(merchantTL);
		
	}

}
