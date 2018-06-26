package com.my.dao.model;

import java.sql.Timestamp;

public class LoomEmpTL {
	private Integer loomEmpId;
	private Integer empId;
	private Integer loomId;
	private String status;
	private Integer createdBy;
	private Timestamp createdOn;
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
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	

}
