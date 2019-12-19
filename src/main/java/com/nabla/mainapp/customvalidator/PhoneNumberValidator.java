package com.nabla.mainapp.customvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nabla.mainapp.Entity.InternInfoModel;

@Component
public class PhoneNumberValidator implements Validator{

	
	String regex="^[6-9]\\d{9}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return InternInfoModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		InternInfoModel internInfoModel=(InternInfoModel)target;
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(internInfoModel.getPhone());
		boolean result=matcher.matches();
		if(!result)
		{
			errors.rejectValue("phone", "phone.notvalid");
		}
	}

}
