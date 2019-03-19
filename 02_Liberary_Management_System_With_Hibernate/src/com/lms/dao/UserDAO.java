package com.lms.dao;

import java.util.List;

import com.lms.beans.UserBean;

public interface UserDAO {
	Integer save();
	Integer update();
	Integer delete();
	List<UserBean> getAllUsers();
	UserBean getUser(String username, String password);
	UserBean getUserByName(String username);
}
