package com.my.service;

import java.util.List;
import java.util.Map;

import com.my.service.dto.LoomEmpDTO;

public interface LoomEmpService {
	public Integer saveLoomEmp(LoomEmpDTO loomEmpDTO);
	public LoomEmpDTO load(Integer loomEmpId);
	public void modify(LoomEmpDTO loomEmpDTO);
	public List<LoomEmpDTO> loadLoomEmps();
	public List<Map<String, Object>> loadLoomsEmps();

}
