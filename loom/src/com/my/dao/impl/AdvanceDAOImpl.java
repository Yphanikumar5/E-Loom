package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.dao.AdvanceDAO;
import com.my.dao.JDBCUtility;
import com.my.dao.model.AdvanceTL;

public class AdvanceDAOImpl implements AdvanceDAO {

	public AdvanceTL getAdvance(Integer advId) {
		AdvanceTL advance=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("select advId,empId,amount,status,createdBy,createdOn from AdvanceTL where advId=?");
			pst.setInt(1, advId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				advance=new AdvanceTL();
				advance.setAdvId(rs.getInt("advId"));
				advance.setEmpId(rs.getInt("empId"));
				advance.setAmount(rs.getDouble("amount"));
				advance.setStatus(rs.getString("status"));
				advance.setCreatedBy(rs.getInt("createdBy"));
				advance.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return advance;
	}

	public List<AdvanceTL> getAdvances() {
		List<AdvanceTL> advances=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select advId,empId,amount,status,createdBy,createdOn from AdvanceTL";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
		//	pst.setInt(1, empId);
			rs=pst.executeQuery();
			advances=new ArrayList<AdvanceTL>();
			while(rs.next())
			{
				AdvanceTL advance=new AdvanceTL();
				advance.setAdvId(rs.getInt("advId"));
				advance.setEmpId(rs.getInt("empId"));
				advance.setAmount(rs.getDouble("amount"));
				advance.setStatus(rs.getString("status"));
				advance.setCreatedBy(rs.getInt("createdBy"));
				advance.setCreatedOn(rs.getTimestamp("createdOn"));
				advances.add(advance);
				
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
		
		return advances;
	}

	public Integer insertAdvance(AdvanceTL advanceTL) {
		PreparedStatement pst=null;
		Integer advId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(advId) as advId from advanceTL");
			if(rs.next())
			{
				advId=rs.getInt("advId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		advId++;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into AdvanceTL(empId,amount,status,createdBy,createdOn,advId)values(?,?,?,?,?,?)");
			pst.setInt(1, advanceTL.getEmpId());
			pst.setDouble(2, advanceTL.getAmount());
			pst.setString(3, advanceTL.getStatus());
			pst.setInt(4, advanceTL.getCreatedBy());
			pst.setTimestamp(5, advanceTL.getCreatedOn());
			pst.setInt(6, advId);
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
		return advId;
		

		
	}

	public void updateAdvance(AdvanceTL advanceTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		try {
			pst=JDBCUtility.getConnection().prepareStatement("update AdvanceTL set amount=?,status=?,createdBy=?,createdOn=? where advId=? and empId=?");
			
			pst.setDouble(1, advanceTL.getAmount());
			pst.setString(2, advanceTL.getStatus());
			pst.setInt(3, advanceTL.getCreatedBy());
			pst.setTimestamp(4, advanceTL.getCreatedOn());
			pst.setInt(5, advanceTL.getAdvId());
			pst.setInt(6, advanceTL.getEmpId());
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

	public Map<String, Object> getEmpAmount(Integer empId) {
		// TODO Auto-generated method stub
		Map<String, Object> amount=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select sum(amount) as amount from advanceTL where empId=?";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
			pst.setInt(1, empId);
			rs=pst.executeQuery();
			Double totalAmount=0.0;
			amount=new HashMap<String, Object>();
			if(rs.next())
			{
				totalAmount=rs.getDouble("amount");
			}
			pst=JDBCUtility.getConnection().prepareStatement("select sum(price*quantity)as productAmount from productTl where empId=?");
			pst.setInt(1, empId);
			Double productAmount=0.0;
			rs=pst.executeQuery();
			if(rs.next())
			{
				productAmount=rs.getDouble("productAmount");
			}
			System.out.println(productAmount);
			amount.put("paidAmount", totalAmount);
			amount.put("totalAmount", productAmount);
			Double balanceAmount=productAmount-totalAmount;
			amount.put("balanceAmount", balanceAmount);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return amount;
	}

}
