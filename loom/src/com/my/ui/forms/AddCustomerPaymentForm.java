package com.my.ui.forms;

public class AddCustomerPaymentForm {
	private Integer customerPayId;
	private Integer customerId;
	private Integer billId;
	private Double paidAmount;
	private String status;
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
	public Integer getCustomerPayId() {
		return customerPayId;
	}
	public void setCustomerPayId(Integer customerPayId) {
		this.customerPayId = customerPayId;
	}
}
