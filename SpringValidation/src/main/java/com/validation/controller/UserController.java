package com.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.validation.customvalidator.PasswordValidator;
import com.validation.customvalidator.StateValidator;
import com.validation.customvalidator.ZipCodeValidator;
import com.validation.entity.UserEntity;
import com.validation.serviceImpl.UserServiceImpl;
import com.validation.utility.LoginModel;
import com.validation.utility.ResetPassword;
import com.validation.utility.StateList;

@Controller
public class UserController {

	ModelAndView modelAndView;

	@Autowired
	UserServiceImpl userservice;
	@Autowired
	StateList stateList;
	@Autowired
	PasswordValidator passwordValidator;
	@Autowired
	ZipCodeValidator zipCodeValidator;
	@Autowired
	StateValidator stateValidator;

	/**
	 * 
	 * Redirect to the registration page
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView redirectToRegistration(@ModelAttribute("form") UserEntity userEntity) {
		modelAndView = new ModelAndView("registration");
		modelAndView.addObject("statelist", stateList.getAllStateList());
		return modelAndView;
	}

	/**
	 * Add the new user
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView addNewUser(@ModelAttribute("form") @Validated UserEntity userEntity, BindingResult result) {

		passwordValidator.validate(userEntity, result);
		zipCodeValidator.validate(userEntity, result);
		stateValidator.validate(userEntity, result);
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("registration");
			modelAndView.addObject("statelist", stateList.getAllStateList());
			return modelAndView;
		} else {
			boolean isUserExist = userservice.checkUserExistance(userEntity.getEmail());
			if (isUserExist != true) {
				userservice.addUser(userEntity);
				modelAndView = new ModelAndView("registration");
				modelAndView.addObject("statelist", stateList.getAllStateList());
				modelAndView.addObject("result", "You are successfully registerd");
			} else {
				modelAndView = new ModelAndView("registration");
				modelAndView.addObject("emailexist", "email is already exist");
			}
			return modelAndView;
		}
	}

	/**
	 * 
	 * redirect to the login page
	 */
	@RequestMapping(value = "/redirectToLogin", method = RequestMethod.GET)
	public String redirectToLogin(@ModelAttribute("loginDetails") LoginModel loginModel) {
		return "login";
	}

	/**
	 * 
	 * login user
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("loginDetails") @Validated LoginModel loginModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("login");
		} else if (loginModel.getEmail().equalsIgnoreCase("admin@mail.com")
				&& loginModel.getPassword().equals("admin")) {
			return new ModelAndView("redirect:views");
		}

		else {
			boolean isLoginDetailsValid = userservice.loginToApplication(loginModel);
			if (isLoginDetailsValid) {
				modelAndView = new ModelAndView("display");
				return modelAndView;
			} else {
				modelAndView = new ModelAndView("login");
				modelAndView.addObject("invalidDetails", "Invalid Email or Password!");
			}
			return modelAndView;
		}

	}

	/**
	 * 
	 * redirect to email
	 */
	@RequestMapping(value = "/redirectToForgotEmail")
	public ModelAndView redirectToForgotPassword(@ModelAttribute("emaildetails") ResetPassword resetPassword) {
		modelAndView = new ModelAndView("forgotemail");
		return modelAndView;
	}

	/**
	 * @param resetPassword
	 * 
	 *                      method is used to check email existance when user want
	 *                      to chnage his password
	 */
	@RequestMapping(value = "/emailexist", method = RequestMethod.POST)
	public ModelAndView forgotPassword(@ModelAttribute("emaildetails") ResetPassword resetPassword) {
		boolean isUserExist = userservice.checkUserExistance(resetPassword.getEmailaddress());
		if (isUserExist != true) {
			modelAndView = new ModelAndView("forgotemail");
			modelAndView.addObject("invalidemailaddress", "Invalid Email Address!");

		} else {
			modelAndView = new ModelAndView("forgotpassword");
			modelAndView.addObject("email", resetPassword.getEmailaddress());
		}
		return modelAndView;
	}

	/**
	 * method used to reset user password using mail
	 */
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String resetPassword(@ModelAttribute("resetPasswordDetails") ResetPassword resetPassword,
			@RequestParam("email") String email) {
		userservice.resetPassword(email, resetPassword.getPassword());
		return "redirect:redirectToLogin";
	}

}
