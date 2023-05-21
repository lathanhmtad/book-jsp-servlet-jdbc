package com.ndd.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.ndd.dao.BookDAO;
import com.ndd.mapper.BookMapper;
import com.ndd.model.BookModel;

public class BookDAOImpl extends AbstractDAOImpl<BookModel> implements BookDAO {
	@Override
	public Long save(BookModel book) {
		book.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		String sql = "insert into book "
				+ "(name, author, price, description, created_date, category_id) "
				+ "values(?,?,?,?,?,?)";
		return insert(sql, 
				book.getName(), 
				book.getAuthor(), 
				book.getPrice(), 
				book.getDescription(), 
				book.getCreatedDate(),
				book.getCategoryId());
	}

	@Override
	public BookModel findOne(Long bookId) {
		String sql = "select b.*, c.name as category_name, c.code as category_code\r\n"
				+ "from book b\r\n"
				+ "join category c on b.category_id = c.id\r\n"
				+ "where b.id = ?;";
		List<BookModel> results = query(sql, new BookMapper(), bookId);

		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<BookModel> findAll() {
		String sql = "select b.*, c.name as category_name, c.code as category_code\r\n"
				+ "from book b\r\n"
				+ "join category c on b.category_id = c.id";
		return query(sql, new BookMapper());
	}

}
