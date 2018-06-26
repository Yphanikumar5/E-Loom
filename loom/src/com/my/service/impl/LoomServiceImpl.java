package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.LoomDAO;
import com.my.dao.impl.LoomDAOImpl;
import com.my.dao.model.LoomTL;
import com.my.service.LoomService;
import com.my.service.dto.LoomDTO;

public class LoomServiceImpl implements LoomService{

	private LoomDAO loomDAO;
	public LoomServiceImpl()
	{
		this.loomDAO=new LoomDAOImpl();
	}
	
	public LoomDTO load(Integer loomId) {
		// TODO Auto-generated method stub
		LoomDTO loomDTO=null;
		LoomTL loomTL=loomDAO.getLoom(loomId);
		if(loomTL!=null)
		{
			loomDTO=new LoomDTO();
			loomDTO.setLoomNo(loomTL.getLoomNo());
			loomDTO.setLoomId(loomTL.getLoomId());
			loomDTO.setLoomAddress(loomTL.getLoomAddress());
			loomDTO.setStatus(loomTL.getStatus());
			loomDTO.setCreatedBy(loomTL.getCreatedBy());
			loomDTO.setCreatedOn(loomTL.getCreatedOn());
			
		}
		return loomDTO;
	}

	public List<LoomDTO> loadLooms() {
		// TODO Auto-generated method stub
		List<LoomDTO> looms=null;
		List<LoomTL> lms=loomDAO.getLooms();
		if(lms!=null)
		{
			looms=new ArrayList(); 
		
			ListIterator<LoomTL> li=lms.listIterator();
			while(li.hasNext())
			{
				LoomDTO loomDTO=new LoomDTO();
				LoomTL loomTL=li.next();
				loomDTO.setLoomNo(loomTL.getLoomNo());
				loomDTO.setLoomId(loomTL.getLoomId());
				loomDTO.setLoomAddress(loomTL.getLoomAddress());
				loomDTO.setStatus(loomTL.getStatus());
				loomDTO.setCreatedBy(loomTL.getCreatedBy());
				loomDTO.setCreatedOn(loomTL.getCreatedOn());
				looms.add(loomDTO);
				
			}
		}
		
		
		return looms;
	}

	public void modify(LoomDTO loomDTO) {
		// TODO Auto-generated method stub
		LoomTL loomTL=new LoomTL();
		loomTL.setLoomNo(loomDTO.getLoomNo());
		loomTL.setLoomAddress(loomDTO.getLoomAddress());
		loomDAO.updateLoom(loomTL);
	}

	public Integer saveLoom(LoomDTO loomDTO) {
		// TODO Auto-generated method stub(
		Integer loomId=0;
		LoomTL loomTL=new LoomTL();
		loomTL.setLoomId(loomDTO.getLoomId());
		loomTL.setLoomNo(loomDTO.getLoomNo());
		loomTL.setLoomAddress(loomDTO.getLoomAddress());
		loomTL.setStatus(loomDTO.getStatus());
		loomTL.setCreatedBy(loomDTO.getCreatedBy());
		loomTL.setCreatedOn(new java.sql.Timestamp(loomDTO.getCreatedOn().getTime()));
		loomId=loomDAO.insertLoom(loomTL);
		
		return loomId;
	}

}
