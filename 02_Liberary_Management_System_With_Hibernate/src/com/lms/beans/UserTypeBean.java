package com.lms.beans;

import java.io.Serializable;

public class UserTypeBean extends Beans implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer userTypeId;
	private String userType;
	
	public UserTypeBean() {
		
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
