package com.ndd.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookDTO extends AbstractDTO<BookDTO> {
	
	private String name;
	private String author;
	private Double price;
	private String description;
	private Long categoryId;
	private CategoryDTO category;
	private List<BookImageDTO> bookImages;
		
	
}
