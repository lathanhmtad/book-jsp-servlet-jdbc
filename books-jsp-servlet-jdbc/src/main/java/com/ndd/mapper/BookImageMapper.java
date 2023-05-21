package com.ndd.mapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Part;

import com.ndd.dto.BookImageDTO;
import com.ndd.model.BookImageModel;

public class BookImageMapper implements PartMapper<BookImageDTO>, RowMapper<BookImageModel> {

	@Override
	public BookImageModel mapRow(ResultSet rs) {
		try {
			BookImageModel result = new BookImageModel();
			result.setBookId(rs.getLong("id"));
			result.setName(rs.getString("name"));
			result.setImgData(rs.getBinaryStream("img_data").readAllBytes());
			result.setFormat(rs.getString("type"));
			result.setBookId(rs.getLong("book_id"));
			result.setCreatedDate(rs.getTimestamp("created_date"));
			
			return result;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public BookImageDTO mapPart(Part part) throws IOException {
		BookImageDTO result = new BookImageDTO();
		result.setName(part.getSubmittedFileName());
		result.setImageData(part.getInputStream().readAllBytes());
		result.setType(part.getContentType());
		return result;
	}

}
