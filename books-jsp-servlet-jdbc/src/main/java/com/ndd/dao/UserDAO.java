package com.ndd.dao;

import com.ndd.model.UserModel;

public interface UserDAO extends GenericDAO<UserModel> {
	UserModel findOneByUsernameAndPassword(String username, String password, Integer status);
}