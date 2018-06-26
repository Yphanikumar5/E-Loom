package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.dao.AdminDAO;
import com.my.dao.JDBCUtility;
import com.my.dao.model.AdminTL;

public class AdminDAOImpl implements AdminDAO{

	public AdminTL getAdmin(String emailId, String password) {
		// TODO Auto-generated method stub
		AdminTL admin=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			
			pst=JDBCUtility.getConnection().prepareStatement("select adminId,firstName,lastname,mobileNumber,emailid,password,createdOn from admintl where emailId=?  and  password=?");
			pst.setString(1, emailId);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next())
			{
				admin=new AdminTL();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setFirstName(rs.getString("firstName"));
				admin.setLastName(rs.getString("lastName"));
				admin.setMobileNumber(rs.getString("mobileNumber"));
				admin.setEmailId(rs.getString("emailId"));
				admin.setPassword(rs.getString("password"));
				admin.setCreatedOn(rs.getTimestamp("createdOn"));
			}
		} catch (SQLException sqle)
		{
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			JDBCUtility.closeResultSet(rs);
			JDBCUtility.closeStatement(pst);
		}
		
		return admin;
	}
	public AdminTL getAdmin(String emailId) {
		// TODO Auto-generated method stub
		AdminTL admin=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			
			pst=JDBCUtility.getConnection().prepareStatement("select adminId,firstName,lastname,mobileNumber,emailid,password,createdOn from admintl where emailId=? ");
			pst.setString(1, emailId);
			
			rs=pst.executeQuery();
			if(rs.next())
			{
				admin=new AdminTL();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setFirstName(rs.getString("firstName"));
				admin.setLastName(rs.getString("lastName"));
				admin.setMobileNumber(rs.getString("mobileNumber"));
				admin.setEmailId(rs.getString("emailId"));
				admin.setPassword(rs.getString("password"));
				admin.setCreatedOn(rs.getTimestamp("createdOn"));
			}
		} catch (SQLException sqle)
		{
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			JDBCUtility.closeResultSet(rs);
			JDBCUtility.closeStatement(pst);
		}
		
		return admin;
	}

}
