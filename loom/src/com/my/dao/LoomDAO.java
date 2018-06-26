package com.my.dao;

import java.util.List;


import com.my.dao.model.LoomTL;

public interface LoomDAO {
	public Integer insertLoom(LoomTL loomTL);
	public LoomTL getLoom(Integer loomId);
	public void updateLoom(LoomTL loomTL);
	public List<LoomTL> getLooms();



}
