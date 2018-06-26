package com.my.service;

import java.util.List;

import com.my.service.dto.RawDTO;

public interface RawService {
	
	public Integer saveRaw(RawDTO rawDTO);
	public RawDTO load(Integer rawId);
	public void modify(RawDTO rawDTO);
	public List<RawDTO> loadRaws();

}
