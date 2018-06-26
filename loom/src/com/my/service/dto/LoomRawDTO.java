package com.my.service.dto;

import java.sql.Timestamp;
import java.util.Date;

public class LoomRawDTO {
	private Integer loomRawId;
	private Integer loomId;
	private Integer rawId;
	private Double quantity;
	private String status;
	private Integer createdBy;
	private Date createdOn;
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
	
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	

}
