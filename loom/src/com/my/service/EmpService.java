package com.my.service;

import java.util.List;

import com.my.service.dto.EmpDTO;

public interface EmpService {
	public Integer saveEmp(EmpDTO empDTO);
	public void modify(EmpDTO empDTO);
	public EmpDTO load(Integer empId);
	public List<EmpDTO> loadEmps();

}
