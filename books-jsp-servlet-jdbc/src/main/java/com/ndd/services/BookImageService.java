package com.ndd.services;

import java.util.List;

import com.ndd.model.BookImageModel;

public interface BookImageService {
	List<BookImageModel> save(List<BookImageModel> list, Long bookId);
}
