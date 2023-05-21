package com.ndd.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookImageDTO extends AbstractDTO<BookImageDTO>  {
	
	private String name;
	private String type;
	private byte[] imageData;
	private String base64Image;
	private Long bookId;
}
