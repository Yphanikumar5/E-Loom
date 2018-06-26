package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.ProductPaymentDAO;
import com.my.dao.model.ProductPaymentTL;

public class ProductPaymentDAOImpl implements ProductPaymentDAO{
	
	public ProductPaymentTL getProductPayment(Integer productPayId) {
		ProductPaymentTL productPayment=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select productPayId,productType,amount,status,createdBy,createdOn from ProductPaymentTL where productPayId=?");
			pst.setInt(1, productPayId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				productPayment=new ProductPaymentTL();
				productPayment.setProductPayId(rs.getInt("productPayId"));
				productPayment.setProductType(rs.getString("productType"));
				productPayment.setAmount(rs.getString("amount"));
				productPayment.setStatus(rs.getString("status"));
				productPayment.setCreatedBy(rs.getInt("createdBy"));
				productPayment.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return productPayment;
	}

	public List<ProductPaymentTL> getProductPayments() {
		List<ProductPaymentTL> productPayments=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="productPayId,productType,amount,status,createdBy,createdOn from ProductPaymentTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
		//	pst.setInt(1, empId);
			pst.executeQuery();
			productPayments=new ArrayList<ProductPaymentTL>();
			while(rs.next())
			{
				ProductPaymentTL productPayment=new ProductPaymentTL();
				productPayment.setProductPayId(rs.getInt("productPayId"));
				productPayment.setProductType(rs.getString("productType"));
				productPayment.setAmount(rs.getString("amount"));
				productPayment.setStatus(rs.getString("status"));
				productPayment.setCreatedBy(rs.getInt("createdBy"));
				productPayment.setCreatedOn(rs.getTimestamp("createdOn"));
				productPayments.add(productPayment);
				
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
		
		return productPayments;
	}

	public Integer insertProductPayment(ProductPaymentTL productPaymentTL) {
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into ProductPaymentTL(productType,amount,status,createdBy,createdOn)values(?,?,?,?,?)");
			pst.setString(1, productPaymentTL.getProductType());
			pst.setString(2, productPaymentTL.getAmount());
			pst.setString(3, productPaymentTL.getStatus());
			pst.setInt(4, productPaymentTL.getCreatedBy());
			pst.setTimestamp(5, productPaymentTL.getCreatedOn());
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

	public void updateProductPayment(ProductPaymentTL productPaymentTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update ProductPaymentTL set amount=?,status=?,createdBy=?,createdOn=?,productType where productPayId=?");
			
			pst.setString(1, productPaymentTL.getAmount());
			pst.setString(2, productPaymentTL.getStatus());
			pst.setInt(3, productPaymentTL.getCreatedBy());
			pst.setTimestamp(4, productPaymentTL.getCreatedOn());
			pst.setString(5, productPaymentTL.getProductType());
			pst.setInt(6, productPaymentTL.getProductPayId());
			
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
