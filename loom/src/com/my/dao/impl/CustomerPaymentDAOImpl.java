package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.CustomerPaymentDAO;
import com.my.dao.JDBCUtility;
import com.my.dao.model.CustomerPaymentTL;

public class CustomerPaymentDAOImpl implements CustomerPaymentDAO {

	/* public CustomerPaymentTL getCustomerPayment(Integer customerPayId) {
		CustomerPaymentTL customerPayment=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("select customerPayId,customerId,amount,status,createdBy,createdOn from customerPaymentTL where customerPayId=?");
			pst.setInt(1, customerPayId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				customerPayment=new CustomerPaymentTL();
				customerPayment.setCustomerPayId(rs.getInt("customerPayId"));
				customerPayment.setCustomerId(rs.getInt("customerId"));
				customerPayment.setAmount(rs.getString("amount"));
				customerPayment.setStatus(rs.getString("status"));
				customerPayment.setCreatedBy(rs.getInt("createdBy"));
				customerPayment.setCreatedOn(rs.getTimestamp("createdOn"));
				
			}
			
			
		} catch (SQLException sqle) {
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
		
		
		
		
		
		
		return customerPayment;
	}

	public List<CustomerPaymentTL> getCustomerPayments() {
		List<CustomerPaymentTL> customerPayments=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			String sql="select customerPayId,customerId,amount,status,createdBy,createdOn from customerpaymenttl";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
		//	pst.setInt(1, customerId);
			rs=pst.executeQuery();
			customerPayments=new ArrayList<CustomerPaymentTL>();
			while(rs.next())
			{
				CustomerPaymentTL customerPayment=new CustomerPaymentTL();
				customerPayment.setCustomerPayId(rs.getInt("customerPayId"));
				customerPayment.setCustomerId(rs.getInt("customerId"));
				customerPayment.setAmount(rs.getString("amount"));
				customerPayment.setStatus(rs.getString("status"));
				customerPayment.setCreatedBy(rs.getInt("createdBy"));
				customerPayment.setCreatedOn(rs.getTimestamp("createdOn"));
				customerPayments.add(customerPayment);
				
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
		
		
		
		return customerPayments;
	}

	public void updateCustomerPayment(CustomerPaymentTL customerPaymentTL) {
		PreparedStatement pst=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("update customerPaymentTL set customerId=?,amount=?,status=?,createdBy=?,createdOn=? where customerPayId=?");
			pst.setInt(1, customerPaymentTL.getCustomerId());
			pst.setString(2, customerPaymentTL.getAmount());
			pst.setString(3, customerPaymentTL.getStatus());
			pst.setInt(4, customerPaymentTL.getCreatedBy());
			pst.setTimestamp(5, customerPaymentTL.getCreatedOn());
			pst.setInt(6, customerPaymentTL.getCustomerPayId());
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
*/
	public Integer insertCustomerPayment(CustomerPaymentTL customerPaymentTL) {
		PreparedStatement pst=null;
		Integer customerPayId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(customerPayId) as customerPayId from customerPaymentTL");
			if(rs.next())
			{
				customerPayId=rs.getInt("customerPayId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		customerPayId++;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("insert into customerPaymentTL(customerId,billId,paidAmount,status,createdBy,createdOn,customerPayId)values(?,?,?,?,?,?,?)");
			pst.setInt(1, customerPaymentTL.getCustomerId());
			pst.setInt(2, customerPaymentTL.getBillId());
			pst.setDouble(3, customerPaymentTL.getPaidAmount());
			pst.setString(4, customerPaymentTL.getStatus());
			pst.setInt(5, customerPaymentTL.getCreatedBy());
			pst.setTimestamp(6, customerPaymentTL.getCreatedOn());
			pst.setInt(7, customerPayId);
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
		return customerPayId;
		
		

	}

}
