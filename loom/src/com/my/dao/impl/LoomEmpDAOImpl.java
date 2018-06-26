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
import com.my.dao.LoomEmpDAO;
import com.my.dao.model.LoomEmpTL;

public class LoomEmpDAOImpl implements LoomEmpDAO{
	public LoomEmpTL getLoomEmp(Integer loomEmpId) {
		LoomEmpTL loomEmp=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select loomEmpId,empId,loomId,status,createdBy,createdOn from LoomEmpTL where loomEmpId=?");
			pst.setInt(1, loomEmpId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				loomEmp=new LoomEmpTL();
				loomEmp.setLoomEmpId(rs.getInt("loomEmpId"));
				loomEmp.setEmpId(rs.getInt("empId"));
				loomEmp.setLoomId(rs.getInt("loomId"));
				loomEmp.setStatus(rs.getString("status"));
				loomEmp.setCreatedBy(rs.getInt("createdBy"));
				loomEmp.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return loomEmp;
	}

	public List<LoomEmpTL> getLoomEmps() {
		List<LoomEmpTL> loomEmps=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select loomEmpId,empId,loomId,status,createdBy,createdOn from LoomEmpTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
	//		pst.setInt(1, empId);
			pst.executeQuery();
			loomEmps=new ArrayList<LoomEmpTL>();
			while(rs.next())
			{
				LoomEmpTL loomEmp=new LoomEmpTL();
				loomEmp.setLoomEmpId(rs.getInt("loomEmpId"));
				loomEmp.setEmpId(rs.getInt("empId"));
				loomEmp.setEmpId(rs.getInt("loomId"));
				loomEmp.setStatus(rs.getString("status"));
				loomEmp.setCreatedBy(rs.getInt("createdBy"));
				loomEmp.setCreatedOn(rs.getTimestamp("createdOn"));
				loomEmps.add(loomEmp);
				
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
		
		return loomEmps;
	}

	public Integer insertLoomEmp(LoomEmpTL loomEmpTL) {
		PreparedStatement pst=null;
		Integer loomEmpId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(loomEmpId) as loomEmpId from loomEmpTL");
			if(rs.next())
			{
				loomEmpId=rs.getInt("loomEmpId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		loomEmpId++;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into LoomEmpTL(empId,loomId,status,createdBy,createdOn,loomEmpId)values(?,?,?,?,?,?)");
			pst.setInt(1, loomEmpTL.getEmpId());
			pst.setInt(2, loomEmpTL.getLoomId());
			pst.setString(3, loomEmpTL.getStatus());
			pst.setInt(4, loomEmpTL.getCreatedBy());
			pst.setTimestamp(5, loomEmpTL.getCreatedOn());
			pst.setInt(6, loomEmpId);
			
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
		return loomEmpId;
		

		
	}

	public void updateLoomEmp(LoomEmpTL loomEmpTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update LoomEmpTL set empId?,loomId=?,status=?,createdBy=?,createdOn=? where loomEmpId=?");
			
			pst.setInt(1, loomEmpTL.getEmpId());
			pst.setInt(2, loomEmpTL.getLoomId());
			pst.setString(3, loomEmpTL.getStatus());
			pst.setInt(4, loomEmpTL.getCreatedBy());
			pst.setTimestamp(5, loomEmpTL.getCreatedOn());
			pst.setInt(6, loomEmpTL.getLoomEmpId());
			
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

	public List<Map<String, Object>> getloomsemps() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> loomsemps=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select e.empId,e.empName,e.mobileNumber,l.loomId,l.loomNo,l.loomAddress,le.loomEmpId,le.createdOn,le.status from emptl e,loomtl l,loomemptl le where le.empId=e.empId and le.loomId=l.loomId";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
			rs=pst.executeQuery();
			loomsemps=new ArrayList<Map<String,Object>>();
			while(rs.next())
			{
				Map<String, Object> loomEmp=new HashMap<String, Object>();
				System.out.println(loomEmp);
				loomEmp.put("empId", rs.getInt("empId"));
				loomEmp.put("empName", rs.getString("empName"));
				loomEmp.put("mobileNumber", rs.getString("mobileNumber"));
				loomEmp.put("loomId",rs.getString("loomId"));
				loomEmp.put("loomNo", rs.getString("loomNo"));
				loomEmp.put("loomAddress", rs.getString("loomAddress"));
				loomEmp.put("loomEmpId", rs.getInt("loomEmpId"));
				loomEmp.put("status", rs.getString("status"));
				loomEmp.put("createdOn", rs.getDate("createdOn"));
				loomsemps.add(loomEmp);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			JDBCUtility.closeStatement(pst);
			
		}
		return loomsemps;
	}


}
