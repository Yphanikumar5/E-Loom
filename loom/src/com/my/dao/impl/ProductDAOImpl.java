package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.ProductDAO;
import com.my.dao.model.ProductTL;

public class ProductDAOImpl implements ProductDAO{
	public ProductTL getProduct(Integer productId) {
		ProductTL product=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select productId,empId,productType,productName,quantity,price,status,createdBy,createdOn from ProductTL where productId=?");
			pst.setInt(1, productId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				product=new ProductTL();
				product.setProductId(rs.getInt("productId"));
				product.setEmpId(rs.getInt("empId"));
				product.setProductType(rs.getString("productType"));
				product.setProductName(rs.getString("productName"));
				product.setQuantity(rs.getDouble("quantity"));
				product.setPrice(rs.getDouble("price"));
				
				product.setStatus(rs.getString("status"));
				product.setCreatedBy(rs.getInt("createdBy"));
				product.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return product;
	}

	public List<ProductTL> getProducts() {
		List<ProductTL> products=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select productId,empId,productType,productName,quantity,price,status,createdBy,createdOn from ProductTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
		//	pst.setInt(1, empId);
			rs=pst.executeQuery();
			products=new ArrayList<ProductTL>();
			while(rs.next())
			{
				ProductTL product=new ProductTL();
				product.setProductId(rs.getInt("productId"));
				product.setEmpId(rs.getInt("empId"));
				product.setProductType(rs.getString("productType"));
				product.setProductName(rs.getString("productName"));
				product.setQuantity(rs.getDouble("quantity"));
				product.setPrice(rs.getDouble("price"));
				
				
				product.setStatus(rs.getString("status"));
				product.setCreatedBy(rs.getInt("createdBy"));
				product.setCreatedOn(rs.getTimestamp("createdOn"));
				products.add(product);
				
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
		
		return products;
	}

	public Integer insertProduct(ProductTL productTL) {
		PreparedStatement pst=null;
		Integer productId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(productId) as productId from productTL");
			if(rs.next())
			{
				productId=rs.getInt("productId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		productId++;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into ProductTL(empId,productName,status,createdBy,createdOn,quantity,price,productType,productId)values(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, productTL.getEmpId());
			pst.setString(2, productTL.getProductName());
			pst.setString(3, productTL.getStatus());
			pst.setInt(4, productTL.getCreatedBy());
			pst.setTimestamp(5, productTL.getCreatedOn());
			pst.setDouble(6, productTL.getQuantity());
			pst.setDouble(7, productTL.getPrice());
			pst.setString(8, productTL.getProductType());
			pst.setInt(9, productId);
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
		return productId;
		

		
	}

	public void updateProduct(ProductTL productTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update ProductTL set empId?,productName=?,status=?,createdBy=?,createdOn=?,quantity=?,price=?,productType=? where productId=?");
			
			pst.setInt(1, productTL.getEmpId());
			pst.setString(2, productTL.getProductName());
			pst.setString(3, productTL.getStatus());
			pst.setInt(4, productTL.getCreatedBy());
			pst.setTimestamp(5, productTL.getCreatedOn());
			pst.setDouble(6, productTL.getQuantity());
			
			pst.setDouble(7, productTL.getPrice());
			pst.setString(8, productTL.getProductType());
			pst.setInt(9, productTL.getProductId());
			
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
