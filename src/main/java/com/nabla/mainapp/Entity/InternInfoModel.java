package com.nabla.mainapp.Entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Interns")
public class InternInfoModel {

	
	@NotEmpty(message = "{name.notempty}")
	private String name;

	@NotEmpty(message = "{email.notEmpty}")
	@Email(message = "{email.valid}")
	private String email;

	private String phone;

	@Size(min = 6, message = "{password.length}")
	private String password;

	@NotEmpty(message = "{confirmpassword.notEmpty}")
	private String confirmPassword;

	@NotEmpty(message = "{gender.notEmpty}")
	private String gender;

	@NotEmpty(message = "{city.notEmpty}")
	private String city;

	@NotEmpty(message = "{address.notEmpty}")
	private String address;

	private String state;

	private String zipcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
