package com.my.dao;

import java.util.List;
import java.util.Map;

import com.my.dao.model.LoomRawTL;

public interface LoomRawDAO {
	public Integer insertLoomRaw(LoomRawTL loomRawTL);
	public LoomRawTL getLoomRaw(Integer loomRawId);
	public void updateLoomRaw(LoomRawTL loomRawTL);
	public List<LoomRawTL> getLoomRaws();
	public List<Map<String,Object>> getloomsraws();

}
