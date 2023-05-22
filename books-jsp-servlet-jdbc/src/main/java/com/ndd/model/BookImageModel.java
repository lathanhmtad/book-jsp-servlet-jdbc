package com.ndd.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class BookImageModel extends AbstractModel<BookImageModel> {
	private String name;
	private String format;
	private byte[] imgData;
	private String base64Image;
	private Long bookId;
	
}
