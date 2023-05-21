package com.ndd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class UserModel extends AbstractModel<UserModel> {
	private String fullName;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String address;
	private Integer status;
	private Long roleId;
	
	private RoleModel role = new RoleModel();
	
}
