package com.lms.transformer;

import com.lms.beans.UserBean;
import com.lms.dto.UserDTO;

public class UserTransformer {
	
	public static UserDTO transform(UserBean userBean) {
		
		UserDTO userDTO = new UserDTO();
		
		if (userBean.getUserId() != null) {
			userDTO.setUserId(userBean.getUserId().toString());
		}
		
		if (userBean.getUsername() != null) {
			userDTO.setUsername(userBean.getUsername());
		}
		
		if (userBean.getPassword() != null) {
			userDTO.setPassword(userBean.getPassword());
		}
		
		return userDTO;
	}
	
}
