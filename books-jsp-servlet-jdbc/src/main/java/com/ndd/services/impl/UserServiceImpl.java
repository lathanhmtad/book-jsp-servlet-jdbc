package com.ndd.services.impl;

import javax.inject.Inject;

import com.ndd.dao.UserDAO;
import com.ndd.model.UserModel;
import com.ndd.services.UserService;

public class UserServiceImpl implements UserService {

	@Inject
	UserDAO dao;
	
	@Override
	public UserModel findOneByUsernameAndPassword(String username, String password, Integer status) {
		return dao.findOneByUsernameAndPassword(username, password, status);
	}

}
