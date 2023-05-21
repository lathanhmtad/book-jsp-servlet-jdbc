package com.ndd.dao;

import java.util.List;

import com.ndd.model.BookModel;

public interface BookDAO extends GenericDAO<BookModel>{
	Long save(BookModel book);

	BookModel findOne(Long bookId);

	List<BookModel> findAll();
	
}
