package com.nabla.mainapp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabla.mainapp.Entity.InternInfoModel;
import com.nabla.mainapp.Service.InternService;
import com.nabla.mainapp.repository.InternRepository;
import com.nabla.mainapp.utility.LoginModel;

@Service
public class InternServiceImpl implements InternService {

	
	@Autowired
	InternRepository internRepository;
	
	
	@Override
	public void addUser(InternInfoModel internInfoModel) {
		
		internRepository.save(internInfoModel);
		
	}

	@Override
	public boolean checkUserExistance(String email) 
	{
		InternInfoModel internInfoModel=internRepository.findByEmail(email);
		if(internInfoModel!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean loginToApplication(LoginModel loginModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPassword(String email, String password) {
		// TODO Auto-generated method stub
		
	}

}
