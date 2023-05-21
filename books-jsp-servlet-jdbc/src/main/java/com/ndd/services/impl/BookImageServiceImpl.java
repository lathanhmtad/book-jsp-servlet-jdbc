package com.ndd.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ndd.converter.BookImageConverter;
import com.ndd.dao.BookImageDAO;
import com.ndd.dto.BookImageDTO;
import com.ndd.model.BookImageModel;
import com.ndd.services.BookImageService;

public class BookImageServiceImpl implements BookImageService {

	@Inject
	BookImageDAO bookImageDAO;
	
	@Override
	public List<BookImageDTO> save(List<BookImageDTO> listDTO, Long bookId) {
		List<BookImageModel> listModel = new ArrayList<>();
		
		for (BookImageDTO bookImageDTO : listDTO) {
			BookImageModel bookImageModel = BookImageConverter.toModel(bookImageDTO);
			bookImageModel.setBookId(bookId);
			listModel.add(bookImageDAO.findOne(bookImageDAO.save(bookImageModel)));
		}
		
		return BookImageConverter.toListDTO(listModel);
	}
	
}
