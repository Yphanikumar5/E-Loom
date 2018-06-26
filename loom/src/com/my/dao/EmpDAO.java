package com.my.dao;

import java.util.List;


import com.my.dao.model.EmpTL;

public interface EmpDAO {
	public Integer insertEmp(EmpTL empTL);
	public EmpTL getEmp(Integer empId);
	public void updateEmp(EmpTL empTL);
	public List<EmpTL> getEmps();


}
