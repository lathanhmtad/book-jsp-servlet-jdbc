package com.ndd.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndd.model.BookModel;
import com.ndd.services.BookService;
import com.ndd.services.CategoryService;
import com.ndd.utils.FormUtil;

@WebServlet("/admin-books")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	CategoryService categoryService;
	
	@Inject
	BookService bookService;
	
    public BookController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookModel model = FormUtil.toModel(BookModel.class, request);
		String view = "";
		
		if(model.getType().equals("list")) {
			// show view list book
			view = "/views/admin/book_management.jsp";
		}
		else if(model.getType().equals("add")) {
			// show view add book
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/add_book.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
