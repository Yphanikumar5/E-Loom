package com.my.service.dto;

import java.sql.Timestamp;
import java.util.Date;

public class LoomEmpDTO {
	private Integer loomEmpId;
	private Integer empId;
	private Integer loomId;
	private String status;
	private Integer createdBy;
	private Date createdOn;
	public Integer getLoomEmpId() {
		return loomEmpId;
	}
	public void setLoomEmpId(Integer loomEmpId) {
		this.loomEmpId = loomEmpId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getLoomId() {
		return loomId;
	}
	public void setLoomId(Integer loomId) {
		this.loomId = loomId;
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
	public void setCreatedOn(Date date) {
		this.createdOn = date;
	}
	

}
