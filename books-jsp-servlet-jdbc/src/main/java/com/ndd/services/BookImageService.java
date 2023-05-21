package com.ndd.services;

import java.util.List;

import com.ndd.dto.BookImageDTO;

public interface BookImageService {
	List<BookImageDTO> save(List<BookImageDTO> list, Long bookId);
}
