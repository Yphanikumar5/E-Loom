package com.my.dao.model;

import java.sql.Timestamp;

public class LoomRawTL {
	private Integer loomRawId;
	private Integer loomId;
	private Integer rawId;
	private Double quantity;
	private String status;
	private Integer createdBy;
	private Timestamp createdOn;
	public Integer getLoomRawId() {
		return loomRawId;
	}
	public void setLoomRawId(Integer loomRawId) {
		this.loomRawId = loomRawId;
	}
	public Integer getLoomId() {
		return loomId;
	}
	public void setLoomId(Integer loomId) {
		this.loomId = loomId;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
