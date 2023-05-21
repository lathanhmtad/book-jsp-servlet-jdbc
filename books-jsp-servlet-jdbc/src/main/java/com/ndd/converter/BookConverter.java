package com.ndd.converter;

import com.ndd.dto.BookDTO;
import com.ndd.dto.CategoryDTO;
import com.ndd.model.BookModel;

public class BookConverter {
	public static BookModel toModel(BookDTO bookDTO) {
		BookModel bookModel = new BookModel();
		bookModel.setCategoryId(bookDTO.getCategoryId());
		bookModel.setName(bookDTO.getName());
		bookModel.setAuthor(bookDTO.getAuthor());
		bookModel.setPrice(bookDTO.getPrice());
		bookModel.setDescription(bookDTO.getDescription());
		bookModel.setCreatedBy(bookDTO.getCreatedBy());
		return bookModel;
	}

	public static BookDTO toDTO(BookModel bookModel) {
		BookDTO bookDTO = new BookDTO();
		
		bookDTO.setId(bookModel.getId());
		bookDTO.setName(bookModel.getName());
		bookDTO.setAuthor(bookModel.getAuthor());
		bookDTO.setPrice(bookModel.getPrice());
		bookDTO.setDescription(bookModel.getDescription());
		bookDTO.setCreatedDate(bookModel.getCreatedDate());
		bookDTO.setCreatedBy(bookModel.getCreatedBy());
		bookDTO.setModifiedDate(bookModel.getModifiedDate());
		bookDTO.setModifiedBy(bookModel.getModifiedBy());
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(bookModel.getCategory().getId());
		categoryDTO.setName(bookModel.getCategory().getName());
		categoryDTO.setCode(bookModel.getCategory().getCode());
		
		bookDTO.setCategory(categoryDTO);
		
		return bookDTO;
	}

	
}
