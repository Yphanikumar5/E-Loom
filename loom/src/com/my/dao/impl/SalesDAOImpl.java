package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.SalesDAO;
import com.my.dao.model.SalesTL;

public class SalesDAOImpl implements SalesDAO{
	
/*	public SalesTL getSales(Integer salesId) {
		SalesTL sales=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select salesId,customerId,productId,quantity,price,status,createdBy,createdOn from SalesTL where salesId=?");
			pst.setInt(1, salesId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				sales=new SalesTL();
				sales.setSalesId(rs.getInt("salesId"));
				sales.setCustomerId(rs.getInt("customerId"));
				sales.setProductId(rs.getInt("productId"));
				sales.setQuantity(rs.getString("quantity"));
				sales.setPrice(rs.getString("price"));
				
				sales.setStatus(rs.getString("status"));
				sales.setCreatedBy(rs.getInt("createdBy"));
				sales.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return sales;
	}

	public List<SalesTL> getSaless() {
		List<SalesTL> saless=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select salesId,customerId,productId,quantity,price,status,createdBy,createdOn, from SalesTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
			//pst.setInt(1, customerId);
			pst.executeQuery();
			saless=new ArrayList<SalesTL>();
			while(rs.next())
			{
				SalesTL sales=new SalesTL();
				sales.setSalesId(rs.getInt("salesId"));
				sales.setCustomerId(rs.getInt("customerId"));
				sales.setProductId(rs.getInt("productId"));
				sales.setQuantity(rs.getString("quantity"));
				sales.setPrice(rs.getString("price"));
				
				
				sales.setStatus(rs.getString("status"));
				sales.setCreatedBy(rs.getInt("createdBy"));
				sales.setCreatedOn(rs.getTimestamp("createdOn"));
				saless.add(sales);
				
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
		
		return saless;
	}
*/
	public Integer insertSales(SalesTL salesTL) {
		PreparedStatement pst=null;
		Integer salesId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(salesId) as salesId from salesTL");
			if(rs.next())
			{
				salesId=rs.getInt("salesId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		salesId++;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into SalesTL(billId,productType,quantity,price,discount,status,createdBy,createdOn,salesId)values(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, salesTL.getBillId());
			pst.setString(2, salesTL.getProductType());
			pst.setInt(3, salesTL.getQuantity());
			pst.setDouble(4, salesTL.getPrice());
			pst.setDouble(5, salesTL.getDiscount());
			pst.setString(6, salesTL.getStatus());
			pst.setInt(7, salesTL.getCreatedBy());
			pst.setTimestamp(8, salesTL.getCreatedOn());
			pst.setInt(9, salesId);
			
			
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
		return salesId;
		

		
	}

	/*
	public void updateSales(SalesTL salesTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update SalesTL set customerId?,productId=?,status=?,createdBy=?,createdOn=?,quantity=?,price=? where salesId=?");
			
			pst.setInt(1, salesTL.getCustomerId());
			pst.setInt(2, salesTL.getProductId());
			pst.setString(3, salesTL.getStatus());
			pst.setInt(4, salesTL.getCreatedBy());
			pst.setTimestamp(5, salesTL.getCreatedOn());
			pst.setString(6, salesTL.getQuantity());
			pst.setInt(7, salesTL.getSalesId());
			pst.setString(8, salesTL.getPrice());
			
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
		
*/
		
	}



