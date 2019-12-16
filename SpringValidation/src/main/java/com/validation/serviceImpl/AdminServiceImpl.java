package com.validation.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.validation.configuration.HibernateConfig;
import com.validation.entity.UserEntity;
import com.validation.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public List<UserEntity> getAllUsersDetails() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<UserEntity> userslist=session.createQuery("FROM UserEntity").list();
		transaction.commit();
		session.close();
		return userslist;
	}

}
