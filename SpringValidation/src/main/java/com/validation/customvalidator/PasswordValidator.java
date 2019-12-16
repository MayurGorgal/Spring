package com.validation.customvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.validation.entity.UserEntity;

public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return  UserEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		// TODO Auto-generated method stub
		
		UserEntity userEntity=(UserEntity)target;
		if(!(userEntity.getPassword().equals(userEntity.getConfirmPassword())))
		{
			errors.rejectValue("confirmPassword","notmatch.password");
		}
		
	}

}
