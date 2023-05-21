package com.ndd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class BookModel extends AbstractModel<BookModel> {
	private String name;
	private String author;
	private Double price;
	private String description;
	private Long categoryId;
	private CategoryModel category;
}
