package com.my.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.dao.BillDAO;
import com.my.dao.JDBCUtility;
import com.my.dao.model.BillTL;
import com.my.dao.model.CustomerPaymentTL;
import com.my.dao.model.SalesTL;

public class BillDAOImpl implements BillDAO{

	public Integer insertBill(BillTL billTL) {
		// TODO Auto-generated method stub
		PreparedStatement pst=null;
		Integer billId=0;
		ResultSet rs=null;
		Statement st=null;
		try {
			st=JDBCUtility.getConnection().createStatement();
			rs=st.executeQuery("select max(billId) as billId from billTL");
			if(rs.next())
			{
				billId=rs.getInt("billId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		billId++;
		
		try {
			pst=JDBCUtility.getConnection().prepareStatement("insert into BillTL(status,createdBy,createdOn,billId,customerId)values(?,?,?,?,?)");
			pst.setString(1, billTL.getStatus());
			pst.setInt(2, billTL.getCreatedBy());
			pst.setTimestamp(3, billTL.getCreatedOn());
			pst.setInt(4, billId);
			pst.setInt(5, billTL.getCustomerId());
			pst.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			JDBCUtility.closeStatement(pst);
		}
		
		return billId;
	}

	public Map<String, Object> getBillDetails(Integer billId) {
		System.out.println(billId);
		// TODO Auto-generated method stub
		Map<String, Object> bill=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select customerId,customerName,customerPhoto,customerType,address,mobileNumber,aadharNumber from customerTL where customerId=(select customerId from billTL where billId=?)";
			pst=JDBCUtility.getConnection().prepareStatement(sql);
			pst.setInt(1, billId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				bill=new HashMap<String, Object>();
				bill.put("customerId", rs.getInt("customerId"));
				bill.put("customerName", rs.getString("customerName"));
				bill.put("customerPhoto", rs.getString("customerPhoto"));
				bill.put("customerType", rs.getString("customerType"));
				bill.put("address", rs.getString("address"));
				bill.put("mobileNumber", rs.getString("mobileNumber"));
				bill.put("aadharNumber", rs.getString("aadharNumber"));
				
				
			}
			System.out.println(bill);
			pst=JDBCUtility.getConnection().prepareStatement("select salesId,productType,quantity,price,discount from salesTL where billId=?");
			pst.setInt(1, billId);
			rs=pst.executeQuery();
			List<SalesTL> sales=new ArrayList<SalesTL>();
			while(rs.next())
			{
				SalesTL sale=new SalesTL();
				sale.setSalesId(rs.getInt("salesId"));
				sale.setProductType(rs.getString("productType"));
				sale.setQuantity(rs.getInt("quantity"));
				sale.setPrice(rs.getDouble("price"));
				sale.setDiscount(rs.getDouble("discount"));
				sales.add(sale);
				
			}
			bill.put("sales", sales);
			pst=JDBCUtility.getConnection().prepareStatement("select customerPayId,paidAmount,createdon from customerPaymentTL where billId=?");
			pst.setInt(1, billId);
			rs=pst.executeQuery();
			List<CustomerPaymentTL> payments=new ArrayList<CustomerPaymentTL>();
			while(rs.next())
			{
				CustomerPaymentTL payment=new CustomerPaymentTL();
				payment.setCustomerPayId(rs.getInt("customerPayId"));
				payment.setPaidAmount(rs.getDouble("paidAmount"));
				payment.setCreatedOn(rs.getTimestamp("createdon"));
				payments.add(payment);
			}
			bill.put("payments", payments);
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bill;
	}

}
