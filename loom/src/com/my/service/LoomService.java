package com.my.service;

import java.util.List;

import com.my.service.dto.LoomDTO;

public interface LoomService {
	public Integer saveLoom(LoomDTO loomDTO);
	public LoomDTO load(Integer loomId);
	public void modify(LoomDTO loomDTO);
	public List<LoomDTO> loadLooms();

}
