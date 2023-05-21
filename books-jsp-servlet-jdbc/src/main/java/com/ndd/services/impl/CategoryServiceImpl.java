package com.ndd.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.ndd.dao.CategoryDAO;
import com.ndd.model.CategoryModel;
import com.ndd.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Inject
	CategoryDAO dao;

	@Override
	public List<CategoryModel> findAll() {
		return dao.findAll();
	}
	
	

}
