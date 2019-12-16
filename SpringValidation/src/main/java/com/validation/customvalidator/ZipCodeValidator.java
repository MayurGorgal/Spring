package com.validation.customvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.validation.entity.UserEntity;

public class ZipCodeValidator implements Validator
{

	String regex="^[1-9][0-9]{5}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		UserEntity userEntity=(UserEntity)target;
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(userEntity.getZipcode());
		boolean result=matcher.matches();
		if(!result)
		{
			errors.rejectValue("zipcode", "zipcode.notvalid");
		}
	}

}
