package com.lms.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Beans implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column (name = "created_by")
	private Integer createdBy;
	
	@Column (name = "created_date")
	private Timestamp createdDate;
	
	@Column (name = "modified_by")
	private Integer modifiedBy;
	
	@Column (name = "modified_date")
	private Timestamp modifiedDate;
	
	@Column (name = "active")
	private Integer active = 1;
	
	public Beans() {
		
	}
	
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
