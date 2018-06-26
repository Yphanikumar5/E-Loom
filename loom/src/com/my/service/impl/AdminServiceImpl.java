package com.my.service.impl;

import com.my.dao.AdminDAO;
import com.my.dao.impl.AdminDAOImpl;
import com.my.dao.model.AdminTL;
import com.my.service.AdminService;
import com.my.service.dto.AdminDTO;

public class AdminServiceImpl implements AdminService {
	private AdminDAO adminDAO;
	public AdminServiceImpl()
	{
		this.adminDAO=new AdminDAOImpl();
	}
	public AdminDTO loadAdmin(String emailId, String password) {
		// TODO Auto-generated method stub
		AdminDTO adminDTO=null;
		AdminTL adminTL=adminDAO.getAdmin(emailId, password);
		if(adminTL!=null)
		{
			adminDTO=new AdminDTO();
			adminDTO.setAdminId(adminTL.getAdminId());
			adminDTO.setFirstName(adminTL.getFirstName());
			adminDTO.setLastName(adminTL.getLastName());
			adminDTO.setMobileNumber(adminTL.getMobileNumber());
			adminDTO.setEmailId(adminTL.getEmailId());
			adminDTO.setPassword(adminTL.getPassword());
			adminDTO.setCreatedOn(adminTL.getCreatedOn());
		}
		return adminDTO;
	}
	public AdminDTO loadAdmin(String emailId) {
		// TODO Auto-generated method stub
		AdminDTO adminDTO=null;
		AdminTL adminTL=adminDAO.getAdmin(emailId);
		if(adminTL!=null)
		{
			adminDTO=new AdminDTO();
			adminDTO.setAdminId(adminTL.getAdminId());
			adminDTO.setFirstName(adminTL.getFirstName());
			adminDTO.setLastName(adminTL.getLastName());
			adminDTO.setMobileNumber(adminTL.getMobileNumber());
			adminDTO.setEmailId(adminTL.getEmailId());
			adminDTO.setPassword(adminTL.getPassword());
			adminDTO.setCreatedOn(adminTL.getCreatedOn());
		}
		return adminDTO;
	}

}
