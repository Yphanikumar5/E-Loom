package com.my.service.dto;

import java.util.Date;

public class LoomDTO {
	private Integer loomId;
	private String loomNo;
	private String loomAddress;
	private String status;
	private Integer createdBy;
	private Date createdOn;
	public Integer getLoomId() {
		return loomId;
	}
	public void setLoomId(Integer loomId) {
		this.loomId = loomId;
	}
	public String getLoomAddress() {
		return loomAddress;
	}
	public void setLoomAddress(String loomAddress) {
		this.loomAddress = loomAddress;
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
	public String getLoomNo() {
		return loomNo;
	}
	public void setLoomNo(String loomNo) {
		this.loomNo = loomNo;
	}

}
