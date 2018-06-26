package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.MerchantPaymentDAO;
import com.my.dao.impl.MerchantPaymentDAOImpl;
import com.my.dao.model.LoomRawTL;
import com.my.dao.model.MerchantPaymentTL;
import com.my.service.MerchantPaymentService;
import com.my.service.dto.LoomRawDTO;
import com.my.service.dto.MerchantPaymentDTO;

public class MerchantPaymentsServiceImpl implements MerchantPaymentService{
	private MerchantPaymentDAO merchantPaymentDAO;
	
	public MerchantPaymentsServiceImpl()
	{
		this.merchantPaymentDAO=new MerchantPaymentDAOImpl();
	}
	
	public MerchantPaymentDTO load(Integer mpayId) {
		// TODO Auto-generated method stub
		MerchantPaymentDTO merchantPaymentDTO=null;
		MerchantPaymentTL merchantPaymentTL=merchantPaymentDAO.getMerchantPayment(mpayId);
		if(merchantPaymentTL!=null)
		{
			
			merchantPaymentDTO=new MerchantPaymentDTO();
			merchantPaymentDTO.setMpayId(merchantPaymentTL.getMpayId());
			merchantPaymentDTO.setPaymentId(merchantPaymentTL.getPaymentId());
			merchantPaymentDTO.setAmount(merchantPaymentTL.getAmount());
			merchantPaymentDTO.setStatus(merchantPaymentTL.getStatus());
			merchantPaymentDTO.setCreatedBy(merchantPaymentTL.getCreatedBy());
			merchantPaymentDTO.setCreatedOn(merchantPaymentTL.getCreatedOn());
			
		}
		
		return merchantPaymentDTO;
	}

	public List<MerchantPaymentDTO> loadMerchantPayments() {
		// TODO Auto-generated method stub
		List<MerchantPaymentDTO> merchantPayments=null;
		List<MerchantPaymentTL> mpay=merchantPaymentDAO.getMerchantPayments();
		if(mpay!=null)
		{
			merchantPayments=new ArrayList();
			ListIterator<MerchantPaymentTL> li=mpay.listIterator();
			while(li.hasNext())
			{
				MerchantPaymentDTO merchantPaymentDTO=new MerchantPaymentDTO();
				MerchantPaymentTL merchantPaymentTL=li.next();
				merchantPaymentDTO.setMpayId(merchantPaymentTL.getMpayId());
				merchantPaymentDTO.setPaymentId(merchantPaymentTL.getPaymentId());
				merchantPaymentDTO.setAmount(merchantPaymentTL.getAmount());
				merchantPaymentDTO.setStatus(merchantPaymentTL.getStatus());
				merchantPaymentDTO.setCreatedBy(merchantPaymentTL.getCreatedBy());
				merchantPaymentDTO.setCreatedOn(merchantPaymentTL.getCreatedOn());
				merchantPayments.add(merchantPaymentDTO);
			}
		
		
	}
		return merchantPayments;
	}
	

	public Integer saveMerchantPayment(MerchantPaymentDTO merchantPaymentDTO) {
		// TODO Auto-generated method stub
		Integer mpayId=0;
		MerchantPaymentTL merchantPaymentTL=new MerchantPaymentTL();
		merchantPaymentTL.setAmount(merchantPaymentDTO.getAmount());
		mpayId=merchantPaymentDAO.insertMerchantPayment(merchantPaymentTL);
		return mpayId;
	}

	public void modify(MerchantPaymentDTO merchantPaymentDTO) {
		// TODO Auto-generated method stub
		MerchantPaymentTL merchantPaymentTL=new MerchantPaymentTL();
		merchantPaymentTL.setAmount(merchantPaymentDTO.getAmount());
		merchantPaymentDAO.updateMerchantPayment(merchantPaymentTL);
	}

}
