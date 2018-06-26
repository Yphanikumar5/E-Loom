package com.my.service;

import java.util.List;
import java.util.Map;

import com.my.service.dto.LoomRawDTO;

public interface LoomRawService {
	public Integer saveLoomRaw(LoomRawDTO loomRawDTO);
	public LoomRawDTO load(Integer loomRawId);
	public void modify(LoomRawDTO loomRawDTO);
	public List<LoomRawDTO> loadLoomRaws();
	public List<Map<String, Object>> loadLoomsRaws();
}
