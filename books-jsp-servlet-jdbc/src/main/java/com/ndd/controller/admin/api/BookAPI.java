package com.ndd.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndd.mapper.BookImageMapper;
import com.ndd.model.BookImageModel;
import com.ndd.model.BookModel;
import com.ndd.services.BookImageService;
import com.ndd.services.BookService;
import com.ndd.utils.HttpUtil;

@WebServlet("/api/admin/v1/books")
@MultipartConfig
public class BookAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	BookService bookService;

	@Inject
	BookImageService bookImageService;

	public BookAPI() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		BookModel bookModel = HttpUtil.toModel(request.getParameter("data"), BookModel.class);
//		bookModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUsername());
		bookModel = bookService.save(bookModel);
		
		
		List<BookImageModel> bookImages = HttpUtil.toListModel(request.getParts(), new BookImageMapper(), "images");
		bookImages = bookImageService.save(bookImages, bookModel.getId());
		bookModel.setBookImages(bookImages);
		
		String bookDTOJson = HttpUtil.toJson(bookModel);
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.getWriter().println(bookDTOJson);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
