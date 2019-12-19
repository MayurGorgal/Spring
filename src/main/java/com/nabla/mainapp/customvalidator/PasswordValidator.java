package com.nabla.mainapp.customvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nabla.mainapp.Entity.InternInfoModel;


@Component
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return  InternInfoModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		// TODO Auto-generated method stub
		
		InternInfoModel internInfoModel=(InternInfoModel)target;
		if(!(internInfoModel.getPassword().equals(internInfoModel.getConfirmPassword())))
		{
			errors.rejectValue("confirmPassword","notmatch.password");
		}
		
	}

}
