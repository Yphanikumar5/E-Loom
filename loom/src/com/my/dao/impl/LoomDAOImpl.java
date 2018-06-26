package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.JDBCUtility;
import com.my.dao.LoomDAO;
import com.my.dao.model.LoomTL;

public class LoomDAOImpl implements LoomDAO {

	public LoomTL getLoom(Integer loomId) {
		LoomTL loom = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = JDBCUtility.getConnection().prepareStatement("select loomId,loomNo,loomAddress,status,createdBy,createdOn from LoomTL where loomId=?");
			pst.setInt(1, loomId);
			rs = pst.executeQuery();
			if (rs.next()) {
				loom = new LoomTL();

				loom.setLoomId(rs.getInt("loomId"));
				loom.setLoomAddress(rs.getString("loomAddress"));
				loom.setLoomNo(rs.getString("loomNo"));
				loom.setStatus(rs.getString("status"));
				loom.setCreatedBy(rs.getInt("createdBy"));
				loom.setCreatedOn(rs.getTimestamp("createdOn"));

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JDBCUtility.closeResultSet(rs);
			JDBCUtility.closeStatement(pst);
		}

		return loom;
	}

	public List<LoomTL> getLooms() {
		List<LoomTL> looms = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select loomId,loomNo,loomAddress,status,createdBy,createdOn from LoomTL";
			pst = JDBCUtility.getConnection().prepareStatement(sql);
			// pst.setInt(1, loomId);
			rs = pst.executeQuery();
			looms = new ArrayList<LoomTL>();
			while (rs.next()) {
				LoomTL loom = new LoomTL();

				loom.setLoomId(rs.getInt("loomId"));
				loom.setLoomNo(rs.getString("loomNo"));
				loom.setLoomAddress(rs.getString("loomAddress"));
				loom.setStatus(rs.getString("status"));
				loom.setCreatedBy(rs.getInt("createdBy"));
				loom.setCreatedOn(rs.getTimestamp("createdOn"));
				looms.add(loom);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		finally {
			JDBCUtility.closeResultSet(rs);
			JDBCUtility.closeStatement(pst);
		}

		return looms;
	}

	public Integer insertLoom(LoomTL loomTL) {
		PreparedStatement pst = null;
		Integer loomId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(loomId) as loomId from loomTL");
			if(rs.next())
			{
				loomId=rs.getInt("loomId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		loomId++;
		try {
			pst = JDBCUtility
					.getConnection()
					.prepareStatement("insert into LoomTL(loomNo,loomAddress,status,createdBy,createdOn,loomId)values(?,?,?,?,?,?)");
			pst.setString(1, loomTL.getLoomNo());
			pst.setString(2, loomTL.getLoomAddress());
			pst.setString(3, loomTL.getStatus());
			pst.setInt(4, loomTL.getCreatedBy());
			pst.setTimestamp(5, loomTL.getCreatedOn());
			pst.setInt(6, loomId);
			pst.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		finally {

			JDBCUtility.closeStatement(pst);
		}
		return loomId;

	}

	public void updateLoom(LoomTL loomTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		try {
			pst = JDBCUtility
					.getConnection()
					.prepareStatement(
							"update LoomTL set loomNo=?,loomAddress=?,status=?,createdBy=?,createdOn=? where advId=? and loomId=?");

			pst.setString(1, loomTL.getLoomNo());
			pst.setString(2, loomTL.getLoomAddress());
			pst.setString(3, loomTL.getStatus());
			pst.setInt(4, loomTL.getCreatedBy());
			pst.setTimestamp(5, loomTL.getCreatedOn());

			pst.setInt(5, loomTL.getLoomId());
			pst.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		finally {

			JDBCUtility.closeStatement(pst);
		}

	}

}
