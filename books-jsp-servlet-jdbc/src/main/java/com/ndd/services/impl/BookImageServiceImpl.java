package com.ndd.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ndd.dao.BookImageDAO;
import com.ndd.model.BookImageModel;
import com.ndd.services.BookImageService;

public class BookImageServiceImpl implements BookImageService {

	@Inject
	BookImageDAO bookImageDAO;

	@Override
	public List<BookImageModel> save(List<BookImageModel> list, Long bookId) {
		List<BookImageModel> listModel = new ArrayList<>();

		for (BookImageModel bookImage : list) {
			bookImage.setBookId(bookId);
			listModel.add(bookImageDAO.findOne(bookImageDAO.save(bookImage)));
		}

		return listModel;
	}

}
