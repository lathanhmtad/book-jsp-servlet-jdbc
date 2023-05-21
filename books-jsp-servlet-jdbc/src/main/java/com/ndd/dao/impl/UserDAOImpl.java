package com.ndd.dao.impl;

import java.util.List;

import com.ndd.dao.UserDAO;
import com.ndd.mapper.UserMapper;
import com.ndd.model.UserModel;

public class UserDAOImpl extends AbstractDAOImpl<UserModel> implements UserDAO {

	@Override
	public UserModel findOneByUsernameAndPassword(String username, String password, Integer status) {
		String sql = "SELECT u.*, r.name as role_name, r.code AS role_code\r\n"
				+ "FROM user u\r\n"
				+ "JOIN role r ON u.role_id = r.id\r\n"
				+ "WHERE username = ? AND password = ? AND status = ?;";
		List<UserModel> users = query(sql, new UserMapper(), username, password, status);
		return users.isEmpty() ? null : users.get(0);
	}



}
