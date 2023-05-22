package com.ndd.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ndd.dao.BookDAO;
import com.ndd.dao.BookImageDAO;
import com.ndd.model.BookImageModel;
import com.ndd.model.BookModel;
import com.ndd.services.BookService;

public class BookServiceImpl implements BookService {

	@Inject
	BookDAO bookDAO;
	
	@Inject
	BookImageDAO bookImageDAO;
	
	@Override
	public BookModel save(BookModel book) {
		Long bookId = bookDAO.save(book);
		return bookDAO.findOne(bookId);
	}

	@Override
	public List<BookModel> findAll() {
		List<BookModel> results = new ArrayList<>();
		
		List<BookModel> books = bookDAO.findAll();
		
		for (BookModel book : books) {
			List<BookImageModel> bookImages = bookImageDAO.findAllByBookId(book.getId());
			
			book.setBookImages(bookImages);
			
			results.add(book);
		}
		return results;
	}
}
