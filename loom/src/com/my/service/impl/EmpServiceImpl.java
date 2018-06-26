package com.my.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.my.dao.EmpDAO;
import com.my.dao.impl.EmpDAOImpl;
import com.my.dao.model.EmpTL;
import com.my.service.EmpService;
import com.my.service.dto.EmpDTO;

public class EmpServiceImpl implements EmpService{
	private EmpDAO empDAO;
	public EmpServiceImpl()
	{
		this.empDAO=new EmpDAOImpl();
	}
	public EmpDTO load(Integer empId) {
		EmpDTO empDTO=null;
		EmpTL empTL=empDAO.getEmp(empId);
		if(empTL!=null)
		{
			empDTO=new EmpDTO();
			empDTO.setEmpId(empTL.getEmpId());
			empDTO.setEmpType(empTL.getEmpType());
			empDTO.setEmpName(empTL.getEmpName());
			empDTO.setPhoto(empTL.getPhoto());
			empDTO.setMobileNumber(empTL.getMobileNumber());
			empDTO.setAadharNumber(empTL.getAadharNumber());
			empDTO.setAccountNumber(empTL.getAccountNumber());
			empDTO.setIfscCode(empTL.getIfscCode());
			empDTO.setBankName(empTL.getBankName());
			empDTO.setAddress(empTL.getAddress());
			empDTO.setStatus(empTL.getStatus());
			empDTO.setCreatedBy(empTL.getCreatedBy());
			empDTO.setCreatedOn(empTL.getCreatedOn());
			
		}
		
		
		return empDTO;
	}
	public void modify(EmpDTO empDTO) {
		EmpTL empTL=new EmpTL();
		empTL.setEmpName(empDTO.getEmpName());
		empTL.setPhoto(empDTO.getPhoto());
		empTL.setMobileNumber(empDTO.getMobileNumber());
		empTL.setAadharNumber(empDTO.getAadharNumber());
		empTL.setAccountNumber(empDTO.getAccountNumber());
		empTL.setIfscCode(empDTO.getIfscCode());
		empTL.setBankName(empDTO.getBankName());
		empTL.setAddress(empDTO.getAddress());
		empTL.setEmpId(empDTO.getEmpId());
		empTL.setCreatedBy(empDTO.getCreatedBy());
		empTL.setCreatedOn(new java.sql.Timestamp(new java.util.Date().getTime()));
		empTL.setEmpName(empDTO.getEmpName());
		empTL.setPhoto(empDTO.getPhoto());
		empTL.setMobileNumber(empDTO.getMobileNumber());
		empTL.setAadharNumber(empDTO.getAadharNumber());
		empTL.setAccountNumber(empDTO.getAccountNumber());
		empTL.setIfscCode(empDTO.getIfscCode());
		empTL.setBankName(empDTO.getBankName());
		empTL.setAddress(empDTO.getAddress());
		empTL.setStatus(empDTO.getStatus());
		empTL.setCreatedBy(empDTO.getCreatedBy());
		empTL.setEmpId(empDTO.getEmpId());
		empTL.setEmpType(empDTO.getEmpType());
		empTL.setCreatedOn(new java.sql.Timestamp(empDTO.getCreatedOn().getTime()));
		empDAO.updateEmp(empTL);
	}
	public Integer saveEmp(EmpDTO empDTO) {
		// TODO Auto-generated method stub
		Integer empId=0;
		EmpTL empTL=new EmpTL();
		
		empTL.setEmpName(empDTO.getEmpName());
		empTL.setPhoto(empDTO.getPhoto());
		empTL.setMobileNumber(empDTO.getMobileNumber());
		empTL.setAadharNumber(empDTO.getAadharNumber());
		empTL.setAccountNumber(empDTO.getAccountNumber());
		empTL.setIfscCode(empDTO.getIfscCode());
		empTL.setBankName(empDTO.getBankName());
		empTL.setAddress(empDTO.getAddress());
		empTL.setStatus(empDTO.getStatus());
		empTL.setCreatedBy(empDTO.getCreatedBy());
		empTL.setEmpId(empDTO.getEmpId());
		empTL.setEmpType(empDTO.getEmpType());
		empTL.setCreatedOn(new java.sql.Timestamp(empDTO.getCreatedOn().getTime()));
		empId=empDAO.insertEmp(empTL);
		
		return empId;
	}
	public List<EmpDTO> loadEmps()
	{
		List<EmpDTO> employess=null;
		List<EmpTL> ems=empDAO.getEmps();
		if(ems!=null)
		{
			employess=new ArrayList();
			ListIterator<EmpTL> li=ems.listIterator();
			while(li.hasNext())
			{
				EmpDTO empDTO=new EmpDTO();
				EmpTL empTL=li.next();
				empDTO.setEmpId(empTL.getEmpId());
				empDTO.setEmpType(empTL.getEmpType());
				empDTO.setEmpName(empTL.getEmpName());
				empDTO.setPhoto(empTL.getPhoto());
				empDTO.setMobileNumber(empTL.getMobileNumber());
				empDTO.setAadharNumber(empTL.getAadharNumber());
				empDTO.setAccountNumber(empTL.getAccountNumber());
				empDTO.setIfscCode(empTL.getIfscCode());
				empDTO.setBankName(empTL.getBankName());
				empDTO.setAddress(empTL.getAddress());
				empDTO.setStatus(empTL.getStatus());
				empDTO.setCreatedBy(empTL.getCreatedBy());
				empDTO.setCreatedOn(empTL.getCreatedOn());
				employess.add(empDTO);
			}
			
		}
		return employess;
		
	}
	

}
