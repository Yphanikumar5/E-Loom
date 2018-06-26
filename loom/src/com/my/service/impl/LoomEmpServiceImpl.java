package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.my.dao.LoomEmpDAO;
import com.my.dao.impl.LoomEmpDAOImpl;
import com.my.dao.model.LoomEmpTL;
import com.my.dao.model.LoomRawTL;
import com.my.service.LoomEmpService;
import com.my.service.LoomRawService;
import com.my.service.dto.LoomEmpDTO;
import com.my.service.dto.LoomRawDTO;

public class LoomEmpServiceImpl implements LoomEmpService{
	
	private LoomEmpDAO loomEmpDAO;
	public LoomEmpServiceImpl()
	{
		this.loomEmpDAO=new LoomEmpDAOImpl();
	}
	public LoomEmpDTO load(Integer loomEmpId) {
		LoomEmpDTO loomEmpDTO=null;
		LoomEmpTL loomEmpTL=loomEmpDAO.getLoomEmp(loomEmpId);
		if(loomEmpId!=null)
		{
			loomEmpDTO=new LoomEmpDTO();
			loomEmpDTO.setLoomEmpId(loomEmpTL.getLoomEmpId());
			loomEmpDTO.setEmpId(loomEmpTL.getEmpId());
			loomEmpDTO.setLoomId(loomEmpTL.getLoomId());
			loomEmpDTO.setStatus(loomEmpTL.getStatus());
			loomEmpDTO.setCreatedBy(loomEmpTL.getCreatedBy());
			loomEmpDTO.setCreatedOn(loomEmpTL.getCreatedOn());
		}
		
		
		return loomEmpDTO;
	}
	public List<LoomEmpDTO> loadLoomEmps() {
		
		List<LoomEmpDTO> loomEmps=null;
		List<LoomEmpTL> lrs=loomEmpDAO.getLoomEmps();
		if(lrs!=null)
		{
			loomEmps=new ArrayList();
			ListIterator<LoomEmpTL> li=lrs.listIterator();
			while(li.hasNext())
			{
				LoomEmpDTO loomEmpDTO=new LoomEmpDTO();
				LoomEmpTL loomEmpTL=li.next();
				loomEmpDTO.setLoomEmpId(loomEmpTL.getLoomEmpId());
				loomEmpDTO.setEmpId(loomEmpTL.getEmpId());
				loomEmpDTO.setLoomId(loomEmpTL.getLoomId());
				loomEmpDTO.setStatus(loomEmpTL.getStatus());
				loomEmpDTO.setCreatedBy(loomEmpTL.getCreatedBy());
				loomEmpDTO.setCreatedOn(loomEmpTL.getCreatedOn());
				loomEmps.add(loomEmpDTO);
			}
		}
		return loomEmps;
	
	}
	public void modify(LoomEmpDTO loomEmpDTO) {
		// TODO Auto-generated method stub
		LoomEmpTL loomEmpTL=new LoomEmpTL();
		
		loomEmpDAO.updateLoomEmp(loomEmpTL);
	}
	public Integer saveLoomEmp(LoomEmpDTO loomEmpDTO) {
		// TODO Auto-generated method stub
		Integer loomEmpId=0;
		LoomEmpTL loomEmpTL=new LoomEmpTL();
		loomEmpTL.setLoomEmpId(loomEmpDTO.getLoomEmpId());
		loomEmpTL.setEmpId(loomEmpDTO.getEmpId());
		loomEmpTL.setLoomId(loomEmpDTO.getLoomId());
		loomEmpTL.setCreatedBy(loomEmpDTO.getCreatedBy());
		loomEmpTL.setStatus(loomEmpDTO.getStatus());
		loomEmpTL.setCreatedOn(new java.sql.Timestamp(loomEmpDTO.getCreatedOn().getTime()));
		loomEmpId=loomEmpDAO.insertLoomEmp(loomEmpTL);
		return loomEmpId;
	}
	public List<Map<String, Object>> loadLoomsEmps() {
		// TODO Auto-generated method stub
		return loomEmpDAO.getloomsemps(); 
	}
	
	}
	
