package com.ndd.dao;

import java.util.List;

import com.ndd.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... params);
	
	Long insert(String sql, Object... params);
}
