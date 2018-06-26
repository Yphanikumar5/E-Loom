package com.my.dao.model;

import java.sql.Timestamp;

public class MerchantPaymentTL {
	private Integer mpayId;
	private Integer paymentId;
	private String amount;
	private String status;
	private Integer createdBy;
	private Timestamp createdOn;
	public Integer getMpayId() {
		return mpayId;
	}
	public void setMpayId(Integer mpayId) {
		this.mpayId = mpayId;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
	

}
