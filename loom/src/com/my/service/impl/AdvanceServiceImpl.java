package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.my.dao.AdvanceDAO;
import com.my.dao.impl.AdvanceDAOImpl;
import com.my.dao.model.AdvanceTL;
import com.my.dao.model.EmpTL;
import com.my.service.AdvanceService;
import com.my.service.dto.AdvanceDTO;

public class AdvanceServiceImpl implements AdvanceService{
	
	private AdvanceDAO advanceDAO;
	public AdvanceServiceImpl()
	{
		this.advanceDAO=new AdvanceDAOImpl();
	}
	
	public AdvanceDTO load(Integer advId) {
		// TODO Auto-generated method stub
		AdvanceDTO advanceDTO=null;
		AdvanceTL advanceTL=advanceDAO.getAdvance(advId);
		if(advanceTL!=null)
		{
			advanceDTO=new AdvanceDTO();
			advanceDTO.setAdvId(advanceTL.getAdvId());
			advanceDTO.setEmpId(advanceTL.getEmpId());
			advanceDTO.setAmount(advanceTL.getAmount());
			advanceDTO.setStatus(advanceTL.getStatus());
			advanceDTO.setCreatedBy(advanceTL.getCreatedBy());
			advanceDTO.setCreatedOn(advanceTL.getCreatedOn());
			
		}
		return advanceDTO;
	}

	public List<AdvanceDTO> loadAdvances() {
		// TODO Auto-generated method stub
		List<AdvanceDTO> advances=null;
		List<AdvanceTL> adv=advanceDAO.getAdvances();
		if(adv!=null)
		{
			advances=new ArrayList();
			ListIterator<AdvanceTL> li=adv.listIterator();
			while(li.hasNext())
			{
				AdvanceDTO advanceDTO=new AdvanceDTO();
				AdvanceTL advanceTL=li.next();
				advanceDTO.setAdvId(advanceTL.getAdvId());
				advanceDTO.setEmpId(advanceTL.getEmpId());
				advanceDTO.setAmount(advanceTL.getAmount());
				advanceDTO.setStatus(advanceTL.getStatus());
				advanceDTO.setCreatedBy(advanceTL.getCreatedBy());
				advanceDTO.setCreatedOn(advanceTL.getCreatedOn());
				advances.add(advanceDTO);
			}
		}
		return advances;
	}

	public void modify(AdvanceDTO advanceDTO) {
		// TODO Auto-generated method stub
		AdvanceTL advanceTL=new AdvanceTL();
		advanceTL.setAmount(advanceDTO.getAmount());
		advanceDAO.updateAdvance(advanceTL);
	}

	public Integer saveAdvance(AdvanceDTO advanceDTO) {
		// TODO Auto-generated method stub
		Integer advId=0;
		
		AdvanceTL advanceTL=new AdvanceTL();
		advanceTL.setAdvId(advanceDTO.getAdvId());
		advanceTL.setEmpId(advanceDTO.getEmpId());
		advanceTL.setAmount(advanceDTO.getAmount());
		advanceTL.setStatus(advanceDTO.getStatus());
		advanceTL.setCreatedOn(new java.sql.Timestamp(advanceDTO.getCreatedOn().getTime()));
		advanceTL.setCreatedBy(advanceDTO.getCreatedBy());
		
		advId=advanceDAO.insertAdvance(advanceTL);
		return advId;
	}

	public Map<String, Object> loadEmpAmount(Integer empId) {
		
		return advanceDAO.getEmpAmount(empId);
	}

}
