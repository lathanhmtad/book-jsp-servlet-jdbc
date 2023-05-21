package com.ndd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndd.model.RoleModel;
import com.ndd.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		UserModel result = new UserModel();
		try {
			result.setId(rs.getLong("id"));
			result.setUsername(rs.getString("username"));
			result.setPassword(rs.getString("password"));
			result.setFullName(rs.getString("full_name"));
			result.setStatus(rs.getInt("status"));
			result.setEmail(rs.getString("email"));
			result.setPhone(rs.getString("phone"));
			result.setAddress(rs.getString("address"));
			result.setRoleId(rs.getLong("role_id"));
			result.setCreatedDate(rs.getTimestamp("created_date"));
			result.setCreatedBy(rs.getString("created_by"));
			result.setModifiedDate(rs.getTimestamp("modified_date"));
			result.setModifiedBy(rs.getString("modified_by"));
			
			RoleModel role = new RoleModel();
			role.setName(rs.getString("role_name"));
			role.setCode(rs.getString("role_code"));
			
			result.setRole(role);
			
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
