package com.ndd.dao;

import java.util.List;

import com.ndd.model.BookImageModel;

public interface BookImageDAO {
	Long save(BookImageModel bookImageModel);

	BookImageModel findOne(Long id);

	List<BookImageModel> findAllByBookId(Long id);
}
