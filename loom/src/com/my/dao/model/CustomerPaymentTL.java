package com.my.dao.model;

import java.sql.Timestamp;

public class CustomerPaymentTL {
	private Integer customerPayId;
	private Integer customerId;
	private Integer billId;
	private Double paidAmount;
	private String status;
	private Integer createdBy;
	private Timestamp createdOn;
	public Integer getCustomerPayId() {
		return customerPayId;
	}
	public void setCustomerPayId(Integer customerPayId) {
		this.customerPayId = customerPayId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}

}
