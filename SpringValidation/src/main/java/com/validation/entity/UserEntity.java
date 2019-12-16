package com.validation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_TABLE")
public class UserEntity {
	@Id
	@Column(name = "UID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "{validation.name.notEmpty}")
	@Column(name = "NAME")
	private String name;

	@NotEmpty(message = "{validation.email.notEmpty}")
	@Email(message = "{validation.email.valid}")
	@Column(name = "EMAIL")
	private String email;

	@Size(min = 6, message = "{validation.password.length}")
	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty(message = "{validation.confirmpassword.notEmpty}")
	@Transient
	private String confirmPassword;

	@NotEmpty(message = "{validation.gender.notEmpty}")
	@Column(name = "GENDER")
	private String gender;

	@NotEmpty(message = "{validation.city.notEmpty}")
	@Column(name = "CITY")
	private String city;

	@NotEmpty(message = "{validation.address.notEmpty}")
	@Column(name="ADDRESS")
	private String address;

	@NotEmpty(message = "{validation.state.notEmpty}")
	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP")
	private String zipcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
