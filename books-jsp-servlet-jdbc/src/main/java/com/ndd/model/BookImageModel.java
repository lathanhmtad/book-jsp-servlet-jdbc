package com.ndd.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class BookImageModel extends AbstractModel<BookImageModel> {
	private String name;
	private String format;
	private byte[] imgData;
	private Long bookId;
	
	@Override
	public String toString() {
		return "BookImageModel [name=" + name + ", format=" + format + ", data=" + imgData + ", bookId="
				+ bookId + "]";
	}
}
