package com.ndd.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ndd.converter.BookConverter;
import com.ndd.converter.BookImageConverter;
import com.ndd.dao.BookDAO;
import com.ndd.dao.BookImageDAO;
import com.ndd.dao.CategoryDAO;
import com.ndd.dto.BookDTO;
import com.ndd.dto.BookImageDTO;
import com.ndd.model.BookImageModel;
import com.ndd.model.BookModel;
import com.ndd.services.BookService;

public class BookServiceImpl implements BookService {

	@Inject
	BookDAO bookDAO;
	
	@Inject
	CategoryDAO categoryDAO;
	
	@Inject
	BookImageDAO bookImageDAO;
	
	@Override
	public BookDTO save(BookDTO bookDTO) {
		BookModel bookModel = BookConverter.toModel(bookDTO);
		Long bookId = bookDAO.save(bookModel);
		return BookConverter.toDTO(bookDAO.findOne(bookId));
	}

	@Override
	public List<BookDTO> findAll() {
		List<BookDTO> results = new ArrayList<>();
		
		List<BookModel> bookModels = bookDAO.findAll();
		for (BookModel bookModel : bookModels) {
			List<BookImageModel> bookImageModes = bookImageDAO.findAllByBookId(bookModel.getId());
			
			BookDTO dto = BookConverter.toDTO(bookModel);
			List<BookImageDTO> bookImageDTOs = BookImageConverter.toListDTO(bookImageModes);
			dto.setBookImages(bookImageDTOs);
			
			results.add(dto);
		}
		
		return results;
	}
}
