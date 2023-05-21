package com.ndd.services;

import java.util.List;

import com.ndd.dto.BookDTO;

public interface BookService {
	BookDTO save(BookDTO bookDTO);

	List<BookDTO> findAll();
}
