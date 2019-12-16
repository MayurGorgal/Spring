package com.validation.serviceImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.validation.configuration.HibernateConfig;
import com.validation.entity.UserEntity;
import com.validation.service.UserService;
import com.validation.utility.LoginModel;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	/**
	 * Add New User To The Database
	 */
	@Override
	public void addUser(UserEntity user) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEmail(user.getEmail().toLowerCase());
		session.save(user);
		transaction.commit();
		session.close();
	}

	/**
	 * return true :- user already exist false:- not exist
	 * 
	 * check user is exist or not using email
	 */
	@Override
	public boolean checkUserExistance(String email) {

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("FROM UserEntity WHERE email=:email");
		query.setParameter("email", email.toLowerCase());
		UserEntity userinfo = (UserEntity) query.uniqueResult();
		transaction.commit();
		session.close();
		if (userinfo != null) {
			return true;
		}
		return false;
	}

	/**
	 * Login to the application Two condition:- if email and password matches then
	 * successful login else display message invalid email or password
	 */
	@Override
	public boolean loginToApplication(LoginModel loginModel) {

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("FROM UserEntity WHERE email=:email");
		query.setParameter("email", loginModel.getEmail().toLowerCase());
		UserEntity userinfo = (UserEntity) query.uniqueResult();
		transaction.commit();
		session.close();
		if (userinfo != null) {
			if (passwordEncoder.matches(loginModel.getPassword(), userinfo.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * reset the password
	 */
	@Override
	public void resetPassword(String email, String password) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("UPDATE UserEntity set password=:password where email=:email");
		query.setParameter("password", passwordEncoder.encode(password));
		query.setParameter("email", email);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

}
