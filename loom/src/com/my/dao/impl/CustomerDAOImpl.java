package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.CustomerDAO;
import com.my.dao.JDBCUtility;
import com.my.dao.model.CustomerTL;

public class CustomerDAOImpl implements CustomerDAO {

	public CustomerTL getCustomer(Integer customerId) {
		
		CustomerTL customer=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("select customerId,customerName,customerPhoto,customerType,address,mobileNumber,aadharNumber,status,createdBy,createdOn from Customertl where customerId=?");
			pst.setInt(1, customerId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				customer=new CustomerTL();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerPhoto(rs.getString("customerPhoto"));
				customer.setCustomerType(rs.getString("customerType"));
				customer.setAddress(rs.getString("address"));
				customer.setMobileNumber(rs.getString("mobileNumber"));
				customer.setAadharNumber(rs.getString("aadharNumber"));
				customer.setStatus(rs.getString("status"));
				customer.setCreatedBy(rs.getInt("createdBy"));
				customer.setCreatedOn(rs.getTimestamp("createdOn"));
				
			}
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			JDBCUtility.closeResultSet(rs);
			JDBCUtility.closeStatement(pst);
		}
		
		
		return customer;
	}

	public List<CustomerTL> getCustomers() {
		List<CustomerTL> customers=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("select customerId,customerName,customerPhoto,customerType,address,mobileNumber,aadharNumber,status,createdBy,createdOn from customertl");
			//pst.setInt(1, customerId);
			rs=pst.executeQuery();
			customers=new ArrayList<CustomerTL>();
			while(rs.next())
			{

				CustomerTL customer=new CustomerTL();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerPhoto(rs.getString("customerPhoto"));
				customer.setCustomerType(rs.getString("customerType"));
				customer.setAddress(rs.getString("address"));
				customer.setMobileNumber(rs.getString("mobileNumber"));
				customer.setAadharNumber(rs.getString("aadharNumber"));
				customer.setStatus(rs.getString("status"));
				customer.setCreatedBy(rs.getInt("createdBy"));
				customer.setCreatedOn(rs.getTimestamp("createdOn"));
				customers.add(customer);
				
			}
			
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			JDBCUtility.closeResultSet(rs);
			JDBCUtility.closeStatement(pst);
		}
		return customers;
	}

	public Integer insertCustomer(CustomerTL customerTL) {
		
		PreparedStatement pst=null;
		Integer customerId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(customerId) as customerId from customerTL");
			if(rs.next())
			{
				customerId=rs.getInt("customerId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		customerId++;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("insert into customerTL(customerName,customerPhoto,customerType,address,mobileNumber,aadharNumber,status,createdBy,createdOn,customerId)values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, customerTL.getCustomerName());
			pst.setString(2, customerTL.getCustomerPhoto());
			pst.setString(3, customerTL.getCustomerType());
			pst.setString(4, customerTL.getAddress());
			pst.setString(5, customerTL.getMobileNumber());
			pst.setString(6, customerTL.getAadharNumber());
			pst.setString(7, customerTL.getStatus());
			pst.setInt(8, customerTL.getCreatedBy());
			pst.setTimestamp(9, customerTL.getCreatedOn());
			pst.setInt(10, customerId);
			pst.executeUpdate();
			
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			JDBCUtility.closeStatement(pst);
		}
		return customerId;
		
		
	}

	public void updateCustomer(CustomerTL customerTL) {
		
		PreparedStatement pst=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("update customerTL set customerName=?,customerPhoto=?,customerType=?,address=?,mobileNumber=?,aadharNumber=?,status=?,createdBy=?,createdOn=? where customerId=?");
			pst.setString(1, customerTL.getCustomerName());
			pst.setString(2, customerTL.getCustomerPhoto());
			pst.setString(3, customerTL.getCustomerType());
			pst.setString(4, customerTL.getAddress());
			pst.setString(5, customerTL.getMobileNumber());
			pst.setString(6, customerTL.getAadharNumber());
			pst.setString(7, customerTL.getStatus());
			pst.setInt(8, customerTL.getCreatedBy());
			pst.setTimestamp(9, customerTL.getCreatedOn());
			pst.setInt(10, customerTL.getCustomerId());
			pst.executeUpdate();
			
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			JDBCUtility.closeStatement(pst);
		}
		
		

	}

}
