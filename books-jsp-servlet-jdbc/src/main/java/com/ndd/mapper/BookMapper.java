package com.ndd.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndd.model.BookModel;
import com.ndd.model.CategoryModel;

public class BookMapper implements RowMapper<BookModel> {

	@Override
	public BookModel mapRow(ResultSet rs) {
		BookModel result = null;
		try {
			result = new BookModel();
			result.setId(rs.getLong("id"));
			result.setName(rs.getString("name"));
			result.setAuthor(rs.getString("author"));
			result.setPrice(rs.getDouble("price"));
			result.setDescription(rs.getString("description"));
			result.setCreatedDate(rs.getTimestamp("created_date"));
			
			CategoryModel category = new CategoryModel();
			category.setId(rs.getLong("category_id"));
			category.setName(rs.getString("category_name"));
			category.setCode(rs.getString("category_code"));
			
			result.setCategory(category);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
