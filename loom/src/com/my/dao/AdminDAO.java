package com.my.dao;

import com.my.dao.model.AdminTL;

public interface AdminDAO {
	public AdminTL getAdmin(String emailId,String password);
	public AdminTL getAdmin(String emailId);

}
