package com.ndd.dao;

import java.util.List;

import com.ndd.model.CategoryModel;

public interface CategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
}
