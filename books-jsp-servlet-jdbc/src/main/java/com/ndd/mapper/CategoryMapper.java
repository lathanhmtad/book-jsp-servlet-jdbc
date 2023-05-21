package com.ndd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndd.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel result = new CategoryModel();
		
		try {
			result.setId(rs.getLong("id"));
			result.setName(rs.getString("name"));
			result.setCode(rs.getString("code"));
			result.setCreatedDate(rs.getTimestamp("created_date"));
			result.setCreatedBy(rs.getString("created_by"));
			result.setModifiedDate(rs.getTimestamp("modified_date"));
			result.setModifiedBy(rs.getString("modified_by"));
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
