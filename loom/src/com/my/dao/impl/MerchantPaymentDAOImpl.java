package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.MerchantPaymentDAO;
import com.my.dao.model.MerchantPaymentTL;

public class MerchantPaymentDAOImpl implements MerchantPaymentDAO{
	public MerchantPaymentTL getMerchantPayment(Integer mpayId) {
		MerchantPaymentTL merchantPayment=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("select mpayId,paymentId,amount,status,createdBy,createdOn from merchantPaymentTL where mpayId=?");
			pst.setInt(1, mpayId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				merchantPayment=new MerchantPaymentTL();
				merchantPayment.setMpayId(rs.getInt("mpayId"));
				merchantPayment.setPaymentId(rs.getInt("paymentId"));
				merchantPayment.setAmount(rs.getString("amount"));
				merchantPayment.setStatus(rs.getString("status"));
				merchantPayment.setCreatedBy(rs.getInt("createdBy"));
				merchantPayment.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		
		
		
		
		return merchantPayment;
	}

	public List<MerchantPaymentTL> getMerchantPayments() {
		List<MerchantPaymentTL> merchantPayments=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			String sql="select mpayId,paymentId,amount,status,createdBy,createdOn from merchantPaymentTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
			//pst.setInt(1, paymentId);
			rs=pst.executeQuery();
			merchantPayments=new ArrayList<MerchantPaymentTL>();
			while(rs.next())
			{
				MerchantPaymentTL merchantPayment=new MerchantPaymentTL();
				merchantPayment.setMpayId(rs.getInt("mpayId"));
				merchantPayment.setPaymentId(rs.getInt("paymentId"));
				merchantPayment.setAmount(rs.getString("amount"));
				merchantPayment.setStatus(rs.getString("status"));
				merchantPayment.setCreatedBy(rs.getInt("createdBy"));
				merchantPayment.setCreatedOn(rs.getTimestamp("createdOn"));
				merchantPayments.add(merchantPayment);
				
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
		
		
		
		return merchantPayments;
	}

	public void updateMerchantPayment(MerchantPaymentTL merchantPaymentTL) {
		PreparedStatement pst=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("update merchantPaymentTL set paymentId=?,amount=?,status=?,createdBy=?,createdOn=? where mpayId=?");
			pst.setInt(1, merchantPaymentTL.getPaymentId());
			pst.setString(2, merchantPaymentTL.getAmount());
			pst.setString(3, merchantPaymentTL.getStatus());
			pst.setInt(4, merchantPaymentTL.getCreatedBy());
			pst.setTimestamp(5, merchantPaymentTL.getCreatedOn());
			pst.setInt(6, merchantPaymentTL.getMpayId());
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

	public Integer insertMerchantPayment(MerchantPaymentTL merchantPaymentTL) {
		PreparedStatement pst=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("insert into merchantPaymentTL(mpayId,amount,status,createdBy,createdOn)values(?,?,?,?,?)");
			pst.setInt(1, merchantPaymentTL.getMpayId());
			pst.setString(2, merchantPaymentTL.getAmount());
			pst.setString(3, merchantPaymentTL.getStatus());
			pst.setInt(4, merchantPaymentTL.getCreatedBy());
			pst.setTimestamp(5, merchantPaymentTL.getCreatedOn());
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
		return null;
		
		

	}


}
