package com.apap.tutorial6.service;

import com.apap.tutorial6.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String passowrd);
	public void changePassword(UserRoleModel user, String newPassword);
	UserRoleModel findUserByUsername(String name);
}
