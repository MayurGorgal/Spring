package com.validation.utility;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {

	@NotEmpty(message = "{validation.name.notEmpty}")
	@Email(message = "{validation.email.valid}")
	private String email;

	@NotEmpty(message = "{validation.password.notEmpty}")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
