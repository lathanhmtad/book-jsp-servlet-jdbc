package com.ndd.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryModel extends AbstractModel<CategoryModel> {
	private String name;
	private String code;
	
	@Override
	public String toString() {
		return "CategoryModel [name=" + name + ", code=" + code + ", getId()=" + getId() + ", getCreatedBy()="
				+ getCreatedBy() + ", getModifiedBy()=" + getModifiedBy() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getModifiedDate()=" + getModifiedDate() + "]";
	}
	
	
}
