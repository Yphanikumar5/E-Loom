package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dao.EmpDAO;
import com.my.dao.JDBCUtility;
import com.my.dao.model.EmpTL;

public class EmpDAOImpl implements EmpDAO{
public EmpTL getEmp(Integer empId) {
		
		EmpTL emp=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("select empid, emptype, empname, photo, mobilenumber, aadharnumber, accountnumber, ifsccode, bankname, address, status, createdby, createdon FROM emptl where empId=?");
			pst.setInt(1, empId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				emp=new EmpTL();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpName(rs.getString("empName"));
				emp.setPhoto(rs.getString("photo"));
				emp.setAddress(rs.getString("address"));
				emp.setMobileNumber(rs.getString("mobileNumber"));
				emp.setAadharNumber(rs.getString("aadharNumber"));
				emp.setAccountNumber(rs.getString("accountNumber"));
				emp.setIfscCode(rs.getString("ifscCode"));
				emp.setBankName(rs.getString("bankName"));
				emp.setEmpType(rs.getString("empType"));
				emp.setStatus(rs.getString("status"));
				emp.setCreatedBy(rs.getInt("createdBy"));
				emp.setCreatedOn(rs.getTimestamp("createdOn"));
				
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
		
		
		return emp;
	}

	public List<EmpTL> getEmps() {
		List<EmpTL> emps=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("select empId,empName,photo,address,mobileNumber,aadharNumber,accountNumber,ifscCode,bankName,empType,status,createdBy,createdOn from emptl");
			//pst.setInt(1, empId);
			rs=pst.executeQuery();
			emps=new ArrayList<EmpTL>();
			while(rs.next())
			{

				EmpTL emp=new EmpTL();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpName(rs.getString("empName"));
				emp.setPhoto(rs.getString("photo"));
				emp.setAddress(rs.getString("address"));
				emp.setMobileNumber(rs.getString("mobileNumber"));
				emp.setAadharNumber(rs.getString("aadharNumber"));
				emp.setAccountNumber(rs.getString("accountNumber"));
				emp.setIfscCode(rs.getString("ifscCode"));
				emp.setBankName(rs.getString("bankName"));
				emp.setEmpType(rs.getString("empType"));
				emp.setStatus(rs.getString("status"));
				emp.setCreatedBy(rs.getInt("createdBy"));
				emp.setCreatedOn(rs.getTimestamp("createdOn"));
				emps.add(emp);
				
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
		return emps;
	}

	public Integer insertEmp(EmpTL empTL) {
		
		PreparedStatement pst=null;
		Integer empId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(empId) as empId from empTL");
			if(rs.next())
			{
				empId=rs.getInt("empId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		empId++;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("insert into empTL(empName,photo,address,mobileNumber,aadharNumber,accountNumber,ifscCode,bankName,empType,status,createdBy,createdOn,empId)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, empTL.getEmpName());
			pst.setString(2, empTL.getPhoto());
			pst.setString(3, empTL.getAddress());
			pst.setString(4, empTL.getMobileNumber());
			pst.setString(5, empTL.getAadharNumber());
			pst.setString(6, empTL.getAccountNumber());
			pst.setString(7, empTL.getIfscCode());
			pst.setString(8, empTL.getBankName());
			pst.setString(9, empTL.getEmpType());
			pst.setString(10, empTL.getStatus());
			pst.setInt(11, empTL.getCreatedBy());
			pst.setTimestamp(12, empTL.getCreatedOn());
			pst.setInt(13, empId);
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
		return empId;
		
		
	}

	public void updateEmp(EmpTL empTL) {
		
		PreparedStatement pst=null;
		try
		{
			pst=JDBCUtility.getConnection().prepareStatement("update empTL set empName=?,photo=?,address=?,mobileNumber=?,aadharNumber=?,accountNumber=?,ifscCode=?,bankName=?,empType=?,status=?,createdBy=?,createdOn=? where empId=?");
			pst.setString(1, empTL.getEmpName());
			pst.setString(2, empTL.getPhoto());
			pst.setString(3, empTL.getAddress());
			pst.setString(4, empTL.getMobileNumber());
			pst.setString(5, empTL.getAadharNumber());
			pst.setString(6, empTL.getAccountNumber());
			pst.setString(7, empTL.getIfscCode());
			pst.setString(8, empTL.getBankName());
			pst.setString(9, empTL.getEmpType());
			pst.setString(10, empTL.getStatus());
			pst.setInt(11, empTL.getCreatedBy());
			pst.setTimestamp(12, empTL.getCreatedOn());
			pst.setInt(13, empTL.getEmpId());
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
