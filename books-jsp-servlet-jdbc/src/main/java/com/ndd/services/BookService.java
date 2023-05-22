package com.ndd.services;

import java.util.List;

import com.ndd.model.BookModel;

public interface BookService {
	BookModel save(BookModel book);

	List<BookModel> findAll();
}
