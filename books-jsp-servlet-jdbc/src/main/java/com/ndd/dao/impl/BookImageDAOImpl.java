package com.ndd.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.ndd.dao.BookImageDAO;
import com.ndd.mapper.BookImageMapper;
import com.ndd.model.BookImageModel;

public class BookImageDAOImpl extends AbstractDAOImpl<BookImageModel> implements BookImageDAO {

	@Override
	public Long save(BookImageModel bookImageModel) {
		bookImageModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		String sql = "insert into book_image "
				+ "(name, type, img_data, book_id, created_date) "
				+ "values(?,?,?,?,?)";
		
		return insert(sql,
				bookImageModel.getName(), 
				bookImageModel.getFormat(),
				bookImageModel.getImgData(),
				bookImageModel.getBookId(),
				bookImageModel.getCreatedDate());
	}

	@Override
	public BookImageModel findOne(Long id) {
		String sql = "select * from book_image where id = ?";
		List<BookImageModel> results = query(sql, new BookImageMapper(), id);
		
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<BookImageModel> findAllByBookId(Long id) {
		String sql = "select * from book_image where book_id = ?";
		return query(sql, new BookImageMapper(), id);
	}

}
