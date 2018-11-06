package com.apap.tutorial6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apap.tutorial6.model.UserRoleModel;
import com.apap.tutorial6.repository.UserRoleDb;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleDb userDb;
	
	@Override
	public UserRoleModel addUser(UserRoleModel user) {
		// TODO Auto-generated method stub
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDb.save(user);
	}

	@Override
	public String encrypt(String passowrd) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(passowrd);
		return hashedPassword;
	}

	@Override
	public void changePassword(UserRoleModel user, String newPassword) {
		// TODO Auto-generated method stub
		String pass = encrypt(newPassword);
		user.setPassword(pass);
		userDb.save(user);
	}

	@Override
	public UserRoleModel findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDb.findByUsername(username);
	}

}
