package com.my.service.dto;

import java.sql.Timestamp;

public class ProductReturnDTO {
	private Integer productReturnId;
	private Integer productId;
	private Integer customerId;
	private String quantity;
	private Integer salesId;
	private String status;
	private Integer createdBy;
	private Timestamp createdOn;
	public Integer getProductReturnId() {
		return productReturnId;
	}
	public void setProductReturnId(Integer productReturnId) {
		this.productReturnId = productReturnId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Integer getSalesId() {
		return salesId;
	}
	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
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
