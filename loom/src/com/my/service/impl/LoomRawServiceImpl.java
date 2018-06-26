package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.my.dao.LoomRawDAO;
import com.my.dao.impl.LoomRawDAOImpl;
import com.my.dao.model.LoomRawTL;
import com.my.service.LoomRawService;
import com.my.service.dto.LoomRawDTO;

public class LoomRawServiceImpl implements LoomRawService{
	private LoomRawDAO loomRawDAO;
	public LoomRawServiceImpl()
	{
		this.loomRawDAO=new LoomRawDAOImpl();
	}
	public LoomRawDTO load(Integer loomRawId) {
		// TODO Auto-generated method stub
		LoomRawDTO loomRawDTO=null;
		LoomRawTL loomRawTL=loomRawDAO.getLoomRaw(loomRawId);
		if(loomRawTL!=null)
		{
			loomRawDTO=new LoomRawDTO();
			loomRawDTO.setLoomRawId(loomRawTL.getLoomRawId());
			loomRawDTO.setLoomId(loomRawTL.getLoomId());
			loomRawDTO.setRawId(loomRawTL.getRawId());
			loomRawDTO.setQuantity(loomRawTL.getQuantity());
			loomRawDTO.setStatus(loomRawTL.getStatus());
			loomRawDTO.setCreatedBy(loomRawTL.getCreatedBy());
			loomRawDTO.setCreatedOn(loomRawTL.getCreatedOn());
			
		}
		return loomRawDTO;
	}

	public List<LoomRawDTO> loadLoomRaws() {
		// TODO Auto-generated method stub
		List<LoomRawDTO> loomRaws=null;
		List<LoomRawTL> lrs=loomRawDAO.getLoomRaws();
		if(lrs!=null)
		{
			loomRaws=new ArrayList();
			ListIterator<LoomRawTL> li=lrs.listIterator();
			while(li.hasNext())
			{
				LoomRawDTO loomRawDTO=new LoomRawDTO();
				LoomRawTL loomRawTL=li.next();
				loomRawDTO.setLoomRawId(loomRawTL.getLoomRawId());
				loomRawDTO.setLoomId(loomRawTL.getLoomId());
				loomRawDTO.setRawId(loomRawTL.getRawId());
				loomRawDTO.setQuantity(loomRawTL.getQuantity());
				loomRawDTO.setStatus(loomRawTL.getStatus());
				loomRawDTO.setCreatedBy(loomRawTL.getCreatedBy());
				loomRawDTO.setCreatedOn(loomRawTL.getCreatedOn());
				loomRaws.add(loomRawDTO);
			}
		}
		
		return loomRaws;
	}

	public void modify(LoomRawDTO loomRawDTO) {
		// TODO Auto-generated method stub
		LoomRawTL loomRawTL=new LoomRawTL();
		loomRawTL.setQuantity(loomRawDTO.getQuantity());
		loomRawDAO.updateLoomRaw(loomRawTL);
	}

	public Integer saveLoomRaw(LoomRawDTO loomRawDTO) {
		// TODO Auto-generated method stub
		Integer loomRawId;
		LoomRawTL loomRawTL=new LoomRawTL();
		loomRawTL.setLoomRawId(loomRawDTO.getLoomRawId());
		loomRawTL.setLoomId(loomRawDTO.getLoomId());
		loomRawTL.setRawId(loomRawDTO.getRawId());
		loomRawTL.setQuantity(loomRawDTO.getQuantity());
		loomRawTL.setStatus(loomRawDTO.getStatus());
		loomRawTL.setCreatedBy(loomRawDTO.getCreatedBy());
		loomRawTL.setCreatedOn(new java.sql.Timestamp(loomRawDTO.getCreatedOn().getTime()));
		loomRawId=loomRawDAO.insertLoomRaw(loomRawTL);
		return loomRawId;
	}
	public List<Map<String, Object>> loadLoomsRaws() {
		// TODO Auto-generated method stub
		return loomRawDAO.getloomsraws();
	}

}
