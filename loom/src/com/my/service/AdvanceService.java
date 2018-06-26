package com.my.service;

import java.util.List;
import java.util.Map;

import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;

import com.my.service.dto.AdvanceDTO;

public interface AdvanceService {

	public Integer saveAdvance(AdvanceDTO advanceDTO);
	public void modify(AdvanceDTO advanceDTO);
	public AdvanceDTO load(Integer advId);
	public List<AdvanceDTO> loadAdvances();
	public Map<String, Object> loadEmpAmount(Integer empId);
}
