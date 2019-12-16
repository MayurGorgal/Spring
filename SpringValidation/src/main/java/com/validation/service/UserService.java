package com.validation.service;

import com.validation.entity.UserEntity;
import com.validation.utility.LoginModel;

public interface UserService {

	/**
	 * add new user
	 */
	void addUser(UserEntity user);

	
	
	/**
	 * check user is exist or not
	 */
	boolean checkUserExistance(String email);

	/**
	 * logged into the application
	 */
	boolean loginToApplication(LoginModel loginModel);

	
	
	/**
	 * reset the password for user
	 */
	void resetPassword(String email,String password);

}