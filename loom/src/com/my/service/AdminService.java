package com.my.service;

import com.my.service.dto.AdminDTO;

public interface AdminService {
	public AdminDTO loadAdmin(String emailId,String password);
	public AdminDTO loadAdmin(String emailId);

}
