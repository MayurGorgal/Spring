package com.nabla.mainapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nabla.mainapp.Entity.InternInfoModel;
import com.nabla.mainapp.ServiceImpl.InternServiceImpl;
import com.nabla.mainapp.customvalidator.PasswordValidator;
import com.nabla.mainapp.customvalidator.PhoneNumberValidator;
import com.nabla.mainapp.customvalidator.StateValidator;
import com.nabla.mainapp.customvalidator.ZipCodeValidator;
import com.nabla.mainapp.utility.LoginModel;
import com.nabla.mainapp.utility.StateList;

@Controller
public class PersonalInfoController {

	ModelAndView modelAndView;

	@Autowired
	InternServiceImpl userservice;
	@Autowired
	StateList stateList;
	@Autowired
	PasswordValidator passwordValidator;
	@Autowired
	ZipCodeValidator zipCodeValidator;
	@Autowired
	StateValidator stateValidator;
	@Autowired
	PhoneNumberValidator PhoneNumberValidator; 

	
	/**
	 * 
	 * Redirect to the registration page
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView redirectToRegistration(@ModelAttribute("form") InternInfoModel userEntity) 
	{
		modelAndView = new ModelAndView("registration");
		modelAndView.addObject("statelist", stateList.getAllStateList());
		return modelAndView;
	}

	/**
	 * Add the new user
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView addNewUser(@ModelAttribute("form") @Validated InternInfoModel inteInfoModel, BindingResult result) {

		passwordValidator.validate(inteInfoModel, result);
		zipCodeValidator.validate(inteInfoModel, result);
		PhoneNumberValidator.validate(inteInfoModel, result);
		stateValidator.validate(inteInfoModel, result);
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("registration");
			modelAndView.addObject("statelist", stateList.getAllStateList());
			return modelAndView;
		} else {
			boolean isUserExist = userservice.checkUserExistance(inteInfoModel.getEmail());
			if (isUserExist != true) {
				userservice.addUser(inteInfoModel);
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
	@GetMapping("/")
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


}
