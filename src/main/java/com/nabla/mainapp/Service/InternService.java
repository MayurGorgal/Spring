package com.nabla.mainapp.Service;

import com.nabla.mainapp.Entity.InternInfoModel;
import com.nabla.mainapp.utility.LoginModel;

public interface InternService {
	
	/**
	 * add new user
	 */
	void addUser(InternInfoModel internInfoModel);

	
	
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
