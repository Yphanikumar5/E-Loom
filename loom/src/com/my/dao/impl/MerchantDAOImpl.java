package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.MerchantDAO;
import com.my.dao.model.MerchantTL;

public class MerchantDAOImpl implements MerchantDAO {

	public MerchantTL getMerchant(Integer merchantId) {
		
		MerchantTL merchant=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			
			pst=JDBCUtility.getConnection().prepareStatement("select merchantId merchantName,merchantPhoto,mobileNumber,address,accountNo,ifscCode,bankName,status,createdBy,createdOn from MerchanttTL where merchantd=?");
			pst.setInt(1, merchantId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				merchant=new MerchantTL();
				merchant.setMerchantId(rs.getInt("merchantId"));
				merchant.setMerchantName(rs.getString("merchantName"));
				merchant.setMerchantPhoto(rs.getString("merchantPhoto"));
				merchant.setMobileNumber(rs.getString("mobileNumber"));
				merchant.setAddress(rs.getString("address"));
				merchant.setAccountNumber(rs.getString("accountNo"));
				merchant.setIfscCode(rs.getString("ifscCode"));
				merchant.setBankName(rs.getString("bankName"));
				merchant.setStatus(rs.getString("status"));
				merchant.setCreatedBy(rs.getInt("createdBy"));
				merchant.setCreatedOn(rs.getTimestamp("createdOn"));
				
				
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
		
		
		
		return merchant;
	}

	public List<MerchantTL> getMerchants() {
		// TODO Auto-generated method stub
		
		List<MerchantTL> merchants=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select merchantName,merchantPhoto,mobileNumber,address,accountNo,ifscCode,bankName,status,createdBy,createdOn from merchantTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
			//pst.setInt(1, merchantId);
			pst.executeQuery();
			merchants=new ArrayList<MerchantTL>();
			while(rs.next())
			{
				MerchantTL merchant=new MerchantTL();
				merchant.setMerchantId(rs.getInt("merchantId"));
				merchant.setMerchantName(rs.getString("merchantName"));
				merchant.setMerchantPhoto(rs.getString("merchantPhoto"));
				merchant.setMobileNumber(rs.getString("mobileNumber"));
				merchant.setAddress(rs.getString("address"));
				merchant.setAccountNumber(rs.getString("accountNo"));
				merchant.setIfscCode(rs.getString("ifscCode"));
				merchant.setBankName(rs.getString("bankName"));
				merchant.setStatus(rs.getString("status"));
				merchant.setCreatedBy(rs.getInt("createdBy"));
				merchant.setCreatedOn(rs.getTimestamp("createdOn"));
				merchants.add(merchant);
				
				
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
		
		
		return merchants;
	}

	public Integer insertMerchant(MerchantTL merchantTL) {
		
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into merchantTL(merchantName,merchantPhoto,mobileNumber,address,accountNo,ifscCode,bankName,status,createdBy,createdOn)values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, merchantTL.getMerchantName());
			pst.setString(2, merchantTL.getMerchantPhoto());
			pst.setString(3, merchantTL.getMobileNumber());
			pst.setString(4, merchantTL.getAddress());
			pst.setString(5, merchantTL.getAccountNumber());
			pst.setString(6, merchantTL.getIfscCode());
			pst.setString(7, merchantTL.getBankName());
			pst.setString(8, merchantTL.getStatus());
			pst.setInt(9, merchantTL.getCreatedBy());
			pst.setTimestamp(10, merchantTL.getCreatedOn());
			pst.executeUpdate();
			
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
			JDBCUtility.closeStatement(pst);
		}
		return null;
		

	}

	public void updateMerchant(MerchantTL merchantTL) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update merchantTL set merchantName=?,merchantPhoto=?,mobileNumber=?,address=?,accountNo=?,ifscCode=?,bankName=?,status=?,createdBy=?,createdOn=? where merchantId=?");
			pst.setString(1, merchantTL.getMerchantName());
			pst.setString(2, merchantTL.getMerchantPhoto());
			pst.setString(3, merchantTL.getMobileNumber());
			pst.setString(4, merchantTL.getAddress());
			pst.setString(5, merchantTL.getAccountNumber());
			pst.setString(6, merchantTL.getIfscCode());
			pst.setString(7, merchantTL.getBankName());
			pst.setString(8, merchantTL.getStatus());
			pst.setInt(9, merchantTL.getCreatedBy());
			pst.setTimestamp(10, merchantTL.getCreatedOn());
			pst.setInt(11, merchantTL.getMerchantId());
			pst.executeUpdate();
			
			
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
			JDBCUtility.closeStatement(pst);
		}
		

		
	}

}
