package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.ProductReturnDAO;
import com.my.dao.model.ProductReturnTL;

public class ProductReturnDAOImpl implements ProductReturnDAO{
	public ProductReturnTL getProductReturn(Integer productReturnId) {
		ProductReturnTL productReturn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select productReturnId,customerId,productId,quantity,salesId,status,createdBy,createdOn from ProductReturnTL where productReturnId=?");
			pst.setInt(1, productReturnId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				productReturn=new ProductReturnTL();
				productReturn.setProductReturnId(rs.getInt("productReturnId"));
				productReturn.setCustomerId(rs.getInt("customerId"));
				productReturn.setProductId(rs.getInt("productId"));
				productReturn.setQuantity(rs.getString("quantity"));
				productReturn.setSalesId(rs.getInt("salesId"));
				
				productReturn.setStatus(rs.getString("status"));
				productReturn.setCreatedBy(rs.getInt("createdBy"));
				productReturn.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return productReturn;
	}

	public List<ProductReturnTL> getProductReturns() {
		List<ProductReturnTL> productReturns=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select productReturnId,customerId,productId,quantity,salesId,status,createdBy,createdOn, from ProductReturnTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
		//	pst.setInt(1, customerId);
			pst.executeQuery();
			productReturns=new ArrayList<ProductReturnTL>();
			while(rs.next())
			{
				ProductReturnTL productReturn=new ProductReturnTL();
				productReturn.setProductReturnId(rs.getInt("productReturnId"));
				productReturn.setCustomerId(rs.getInt("customerId"));
				productReturn.setProductId(rs.getInt("productId"));
				productReturn.setQuantity(rs.getString("quantity"));
				productReturn.setSalesId(rs.getInt("salesId"));
				
				
				productReturn.setStatus(rs.getString("status"));
				productReturn.setCreatedBy(rs.getInt("createdBy"));
				productReturn.setCreatedOn(rs.getTimestamp("createdOn"));
				productReturns.add(productReturn);
				
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
		
		return productReturns;
	}

	public Integer insertProductReturn(ProductReturnTL productReturnTL) {
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into ProductReturnTL(customerId,productId,status,createdBy,createdOn,quantity,salesId)values(?,?,?,?,?,?,?)");
			pst.setInt(1, productReturnTL.getCustomerId());
			pst.setInt(2, productReturnTL.getProductId());
			pst.setString(3, productReturnTL.getStatus());
			pst.setInt(4, productReturnTL.getCreatedBy());
			pst.setTimestamp(5, productReturnTL.getCreatedOn());
			pst.setString(6, productReturnTL.getQuantity());
			pst.setInt(7, productReturnTL.getSalesId());
			
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

	public void updateProductReturn(ProductReturnTL productReturnTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update ProductReturnTL set customerId?,productId=?,status=?,createdBy=?,createdOn=?,quantity=?,salesId=? where productReturnId=?");
			
			pst.setInt(1, productReturnTL.getCustomerId());
			pst.setInt(2, productReturnTL.getProductId());
			pst.setString(3, productReturnTL.getStatus());
			pst.setInt(4, productReturnTL.getCreatedBy());
			pst.setTimestamp(5, productReturnTL.getCreatedOn());
			pst.setString(6, productReturnTL.getQuantity());
			pst.setInt(7, productReturnTL.getSalesId());
			pst.setInt(8, productReturnTL.getProductReturnId());
			
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
