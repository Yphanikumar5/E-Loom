package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.RawDAO;
import com.my.dao.model.RawTL;

public class RawDAOImpl implements RawDAO{
	public RawTL getRaw(Integer rawId) {
		RawTL raw=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select rawId,materialName,price,status,createdBy,createdOn from RawTL where rawId=?");
			pst.setInt(1, rawId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				raw=new RawTL();
				raw.setRawId(rs.getInt("rawId"));
			//	raw.setMerchantId(rs.getInt("merchantId"));
				raw.setMaterialName(rs.getString("materialName"));
			//	raw.setQuantity(rs.getString("quantity"));
				raw.setPrice(rs.getDouble("price"));
				
				raw.setStatus(rs.getString("status"));
				raw.setCreatedBy(rs.getInt("createdBy"));
				raw.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return raw;
	}

	public List<RawTL> getRaws() {
		List<RawTL> raws=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select rawId,materialName,price,status,createdBy,createdOn from RawTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
		//	pst.setInt(1, merchantId);
			rs=pst.executeQuery();
			raws=new ArrayList<RawTL>();
			while(rs.next())
			{
				RawTL raw=new RawTL();
				raw.setRawId(rs.getInt("rawId"));
			//	raw.setMerchantId(rs.getInt("merchantId"));
				raw.setMaterialName(rs.getString("materialName"));
			//	raw.setQuantity(rs.getString("quantity"));
				raw.setPrice(rs.getDouble("price"));
				
				
				raw.setStatus(rs.getString("status"));
				raw.setCreatedBy(rs.getInt("createdBy"));
				raw.setCreatedOn(rs.getTimestamp("createdOn"));
				raws.add(raw);
				
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
		
		return raws;
	}

	public Integer insertRaw(RawTL rawTL) {
		PreparedStatement pst=null;
		Integer rawId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(rawId) as rawId from rawTL");
			if(rs.next())
			{
				rawId=rs.getInt("rawId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rawId++;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into RawTL(materialName,status,createdBy,createdOn,price,rawId)values(?,?,?,?,?,?)");
		//	pst.setInt(1, rawTL.getMerchantId());
			pst.setString(1, rawTL.getMaterialName());
			pst.setString(2, rawTL.getStatus());
			pst.setInt(3, rawTL.getCreatedBy());
			pst.setTimestamp(4, rawTL.getCreatedOn());
		//	pst.setString(6, rawTL.getQuantity());
			pst.setDouble(5, rawTL.getPrice());
			pst.setInt(6, rawId);
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
		return rawId;
		

		
	}

	public void updateRaw(RawTL rawTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update RawTL set materialName=?,status=?,createdBy=?,createdOn=?,price=? where rawId=?");
			
		//	pst.setInt(1, rawTL.getMerchantId());
			pst.setString(1, rawTL.getMaterialName());
			pst.setString(2, rawTL.getStatus());
			pst.setInt(3, rawTL.getCreatedBy());
			pst.setTimestamp(4, rawTL.getCreatedOn());
		//	pst.setString(6, rawTL.getQuantity());
			pst.setDouble(5, rawTL.getPrice());
			pst.setInt(6, rawTL.getRawId());
			
			
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
