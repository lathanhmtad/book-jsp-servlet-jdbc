package com.ndd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RoleModel extends AbstractModel<RoleModel> {
	private String name;
	private String code;
}
