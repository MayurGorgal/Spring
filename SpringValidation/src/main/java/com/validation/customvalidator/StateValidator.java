package com.validation.customvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.validation.entity.UserEntity;

public class StateValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		UserEntity userEntity=(UserEntity)target;
		
		if(userEntity.getState().equals("NONE"))
		{
			errors.rejectValue("state", "state.notselected");
		}
	}
	
}
