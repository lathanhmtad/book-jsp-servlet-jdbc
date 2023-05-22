package com.ndd.mapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.zip.DataFormatException;

import javax.servlet.http.Part;

import com.ndd.model.BookImageModel;
import com.ndd.utils.ImageUtil;

public class BookImageMapper implements PartMapper<BookImageModel>, RowMapper<BookImageModel> {

	@Override
	public BookImageModel mapRow(ResultSet rs) {
		try {
			BookImageModel result = new BookImageModel();
			result.setBookId(rs.getLong("id"));
			result.setName(rs.getString("name"));
			byte[] imageData = ImageUtil.decompressImage(rs.getBinaryStream("img_data").readAllBytes());
			result.setBase64Image(Base64.getEncoder().encodeToString(imageData));
			result.setFormat(rs.getString("type"));
			result.setBookId(rs.getLong("book_id"));
			result.setCreatedDate(rs.getTimestamp("created_date"));
			
			return result;
		} catch (SQLException | IOException | DataFormatException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public BookImageModel mapPart(Part part) throws IOException {
		BookImageModel result = new BookImageModel();
		result.setName(part.getSubmittedFileName());
		result.setImgData(part.getInputStream().readAllBytes());
		result.setType(part.getContentType());
		return result;
	}

}
