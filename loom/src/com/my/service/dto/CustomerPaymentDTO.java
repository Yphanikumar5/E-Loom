package com.my.service.dto;


import java.util.Date;

public class CustomerPaymentDTO {
	private Integer customerPayId;
	private Integer customerId;
	private Integer billId;
	private Double paidAmount;
	private String status;
	private Integer createdBy;
	private Date createdOn;
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
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
