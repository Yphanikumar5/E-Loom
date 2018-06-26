package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.dao.JDBCUtility;
import com.my.dao.LoomRawDAO;
import com.my.dao.model.LoomRawTL;

public class LoomRawDAOImpl implements LoomRawDAO{
	
	
		public LoomRawTL getLoomRaw(Integer loomRawId) {
			LoomRawTL loomRaw=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				pst=JDBCUtility.getConnection().prepareStatement("select loomRawId,rawId,loomId,quantity,status,createdBy,createdOn from LoomRawTL where loomRawId=?");
				pst.setInt(1, loomRawId);
				rs=pst.executeQuery();
				if(rs.next())
				{
					loomRaw=new LoomRawTL();
					loomRaw.setLoomRawId(rs.getInt("loomRawId"));
					loomRaw.setRawId(rs.getInt("rawId"));
					loomRaw.setLoomId(rs.getInt("loomId"));
					loomRaw.setQuantity(rs.getDouble("quantity"));
					loomRaw.setStatus(rs.getString("status"));
					loomRaw.setCreatedBy(rs.getInt("createdBy"));
					loomRaw.setCreatedOn(rs.getTimestamp("createdOn"));
					
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
			
			
			return loomRaw;
		}

		public List<LoomRawTL> getLoomRaws() {
			List<LoomRawTL> loomRaws=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				String sql="select loomRawId,rawId,loomId,quantity,status,createdBy,createdOn, from LoomRawTL";
				pst=JDBCUtility.getConnection().prepareStatement(sql);
			//	pst.setInt(1, loomId);
				pst.executeQuery();
				loomRaws=new ArrayList<LoomRawTL>();
				while(rs.next())
				{
					LoomRawTL loomRaw=new LoomRawTL();
					loomRaw.setLoomRawId(rs.getInt("loomRawId"));
					loomRaw.setRawId(rs.getInt("rawId"));
					loomRaw.setLoomId(rs.getInt("loomId"));
					loomRaw.setQuantity(rs.getDouble("quantity"));
					
					loomRaw.setStatus(rs.getString("status"));
					loomRaw.setCreatedBy(rs.getInt("createdBy"));
					loomRaw.setCreatedOn(rs.getTimestamp("createdOn"));
					loomRaws.add(loomRaw);
					
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
			
			return loomRaws;
		}

		public Integer insertLoomRaw(LoomRawTL loomRawTL) {
			PreparedStatement pst=null;
			Integer loomRawId=0;
			ResultSet rs=null;
			Statement st=null;
			try {
				st=JDBCUtility.getConnection().createStatement();
				rs=st.executeQuery("select max(loomRawId) as loomRawId from loomRawTL");
				if(rs.next())
				{
					loomRawId=rs.getInt("loomRawId");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			loomRawId++;
			try {
				pst=JDBCUtility.getConnection().prepareStatement("insert into LoomRawTL(rawId,loomId,status,createdBy,createdOn,quantity,loomRawId)values(?,?,?,?,?,?,?)");
				pst.setInt(1, loomRawTL.getRawId());
				pst.setInt(2, loomRawTL.getLoomId());
				pst.setString(3, loomRawTL.getStatus());
				pst.setInt(4, loomRawTL.getCreatedBy());
				pst.setTimestamp(5, loomRawTL.getCreatedOn());
				pst.setDouble(6, loomRawTL.getQuantity());
				pst.setInt(7, loomRawId);
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
			return loomRawId;
			

			
		}

		public void updateLoomRaw(LoomRawTL loomRawTL) {
			// TODO Auto-generated method stub
			PreparedStatement pst=null;
			try {
				pst=JDBCUtility.getConnection().prepareStatement("update LoomRawTL set rawId?,loomId=?,status=?,createdBy=?,createdOn=?,quantity=? where loomRawId=?");
				
				pst.setInt(1, loomRawTL.getRawId());
				pst.setInt(2, loomRawTL.getLoomId());
				pst.setString(3, loomRawTL.getStatus());
				pst.setInt(4, loomRawTL.getCreatedBy());
				pst.setTimestamp(5, loomRawTL.getCreatedOn());
				pst.setDouble(6, loomRawTL.getQuantity());
				pst.setInt(7, loomRawTL.getLoomRawId());
				
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

		public List<Map<String, Object>> getloomsraws() {
			
			List<Map<String, Object>> loomsraws=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
				String sql="select l.loomId,l.loomNo,l.loomAddress,r.rawId,r.materialName,r.price,lr.loomRawId,lr.quantity,lr.createdOn,lr.status from loomtl l,rawtl r,loomrawtl lr where lr.loomId=l.loomId and lr.rawId=r.rawId";
				pst=JDBCUtility.getConnection().prepareStatement(sql);
				rs=pst.executeQuery();
				loomsraws=new ArrayList<Map<String,Object>>();
				while(rs.next())
				{
					Map<String, Object> loomRaw=new HashMap<String, Object>();
					loomRaw.put("loomId", rs.getInt("loomId"));
					loomRaw.put("loomNo", rs.getString("loomNo"));
					loomRaw.put("loomAddress", rs.getString("loomAddress"));
					loomRaw.put("rawId", rs.getInt("rawId"));
					loomRaw.put("materialName", rs.getString("materialName"));
					loomRaw.put("price", rs.getDouble("price"));
					loomRaw.put("loomRawId", rs.getInt("loomRawId"));
					loomRaw.put("quantity", rs.getDouble("quantity"));
					loomRaw.put("createdOn", rs.getDate("createdOn"));
				//	loomRaw.put("createdBy", rs.getString("createdBy"));
					loomRaw.put("status", rs.getString("status"));
					loomsraws.add(loomRaw);
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
				JDBCUtility.closeStatement(pst);
			}
			return loomsraws;
		}


}

