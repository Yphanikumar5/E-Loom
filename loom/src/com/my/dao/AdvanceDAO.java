package com.my.dao;

import java.util.List;
import java.util.Map;

import com.my.dao.model.AdvanceTL;

public interface AdvanceDAO {
	
	public Integer insertAdvance(AdvanceTL advanceTL);
	public AdvanceTL getAdvance(Integer advId);
	public void updateAdvance(AdvanceTL advanceTL);
	public List<AdvanceTL> getAdvances();
	public Map<String, Object> getEmpAmount(Integer empId);

}
