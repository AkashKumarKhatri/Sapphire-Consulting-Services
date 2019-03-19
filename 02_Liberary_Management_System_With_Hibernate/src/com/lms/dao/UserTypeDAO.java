package com.lms.dao;

import java.util.List;

import com.lms.beans.UserTypeBean;

public interface UserTypeDAO {
	Integer save();
	Integer update();
	Integer delete();
	List<UserTypeBean> getAllUserType();
}
