package com.ndd.dao.impl;

import java.util.List;

import com.ndd.dao.CategoryDAO;
import com.ndd.mapper.CategoryMapper;
import com.ndd.model.CategoryModel;

public class CategoryDAOImpl extends AbstractDAOImpl<CategoryModel> implements CategoryDAO {


	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "select * from category where id = ?";
		List<CategoryModel> results = query(sql, new CategoryMapper(), id);
		
		return results.isEmpty() ? null : results.get(0);
	}

}
