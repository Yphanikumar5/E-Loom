package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.RawDAO;
import com.my.dao.impl.RawDAOImpl;
import com.my.dao.model.LoomRawTL;
import com.my.dao.model.RawTL;
import com.my.service.RawService;
import com.my.service.dto.LoomRawDTO;
import com.my.service.dto.RawDTO;

public class RawServiceImpl implements RawService{
	private RawDAO rawDAO;
	
	public RawServiceImpl()
	{
		this.rawDAO=new RawDAOImpl();
	}
	
	public RawDTO load(Integer rawId) {
		// TODO Auto-generated method stub
		RawDTO rawDTO=null;
		RawTL rawTL=rawDAO.getRaw(rawId);
		if(rawTL!=null)
		{
			rawDTO=new RawDTO();
			rawDTO.setRawId(rawTL.getRawId());
			//rawDTO.setMerchantId(rawTL.getMerchantId());
			//rawDTO.setQuantity(rawTL.getQuantity());
			rawDTO.setMaterialName(rawTL.getMaterialName());
			rawDTO.setPrice(rawTL.getPrice());
			rawDTO.setStatus(rawTL.getStatus());
			rawDTO.setCreatedBy(rawTL.getCreatedBy());
			rawDTO.setCreatedOn(rawTL.getCreatedOn());
		
		}
		return rawDTO;
		
		
	}

	public List<RawDTO> loadRaws() {
		// TODO Auto-generated method stub
		
	
		
		List<RawDTO> raws=null;
		List<RawTL> raw=rawDAO.getRaws();
		if(raw!=null)
		{
			raws=new ArrayList();
			ListIterator<RawTL> li=raw.listIterator();
			while(li.hasNext())
			{
				RawDTO rawDTO=new RawDTO();
				RawTL rawTL=li.next();
				rawDTO.setRawId(rawTL.getRawId());
				//rawDTO.setMerchantId(rawTL.getMerchantId());
				//rawDTO.setQuantity(rawTL.getQuantity());
				rawDTO.setMaterialName(rawTL.getMaterialName());
				rawDTO.setPrice(rawTL.getPrice());
				rawDTO.setStatus(rawTL.getStatus());
				rawDTO.setCreatedBy(rawTL.getCreatedBy());
				rawDTO.setCreatedOn(rawTL.getCreatedOn());
				raws.add(rawDTO);
			}
		}
		
		return raws;
		
	}

	
	
	public Integer saveRaw(RawDTO rawDTO) {
		// TODO Auto-generated method stub
		Integer rawId;
		RawTL rawTL=new RawTL();
		//rawTL.setQuantity(rawDTO.getQuantity());
		rawTL.setRawId(rawDTO.getRawId());
		rawTL.setMaterialName(rawDTO.getMaterialName());
		rawTL.setPrice(rawDTO.getPrice());
		rawTL.setStatus(rawDTO.getStatus());
		rawTL.setCreatedBy(rawDTO.getCreatedBy());
		rawTL.setCreatedOn(new java.sql.Timestamp(rawDTO.getCreatedOn().getTime()));
		rawId=rawDAO.insertRaw(rawTL);
		
		return rawId;
	}

	public void modify(RawDTO rawDTO) {
		// TODO Auto-generated method stub
		RawTL rawTL=new RawTL();
	//	rawTL.setQuantity(rawDTO.getQuantity());
		rawTL.setMaterialName(rawDTO.getMaterialName());
		rawTL.setPrice(rawDTO.getPrice());
		rawDAO.updateRaw(rawTL);
	}

}
