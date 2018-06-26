package com.my.service.dto;

import java.sql.Timestamp;

public class ProductPaymentDTO {
	private Integer productPayId;
	private String productType;
	private String amount;
	private String status;
	private Integer createdBy;
	private Timestamp createdOn;
	public Integer getProductPayId() {
		return productPayId;
	}
	public void setProductPayId(Integer productPayId) {
		this.productPayId = productPayId;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
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
