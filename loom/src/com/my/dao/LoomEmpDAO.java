package com.my.dao;

import java.util.List;
import java.util.Map;

import com.my.dao.model.LoomEmpTL;

public interface LoomEmpDAO {
	public Integer insertLoomEmp(LoomEmpTL loomEmpTL);
	public LoomEmpTL getLoomEmp(Integer loomEmpId);
	public void updateLoomEmp(LoomEmpTL loomEmpTL);
	public List<LoomEmpTL> getLoomEmps();
	public List<Map<String,Object>> getloomsemps();

}
