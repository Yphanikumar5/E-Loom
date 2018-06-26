package com.my.dao;

import java.util.List;

import com.my.dao.model.RawTL;

public interface RawDAO {
	public Integer insertRaw(RawTL rawTL);
	public RawTL getRaw(Integer rawId);
	public void updateRaw(RawTL rawTL);
	public List<RawTL> getRaws();

}
