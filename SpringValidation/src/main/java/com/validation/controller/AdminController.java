package com.validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.validation.entity.UserEntity;
import com.validation.serviceImpl.AdminServiceImpl;

@Controller
public class AdminController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	private ModelAndView modelAndView;

	@RequestMapping(value = "/views")
	public ModelAndView showUserDetails() 
	{
		List<UserEntity> usersDetailList = adminServiceImpl.getAllUsersDetails();
		modelAndView = new ModelAndView("admin/usersdetails");
		modelAndView.addObject("userlist", usersDetailList);
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/redirecttoupdate",method = RequestMethod.GET)
	public ModelAndView redirectToUpdateDetailsPage(@RequestParam("email") String email)
	{
		
		modelAndView=new ModelAndView("/admin/updatedetails");
		return modelAndView;
	}
}
