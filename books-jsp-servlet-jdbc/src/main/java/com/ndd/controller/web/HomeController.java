package com.ndd.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndd.model.BookModel;
import com.ndd.model.UserModel;
import com.ndd.services.BookService;
import com.ndd.services.UserService;
import com.ndd.utils.FormUtil;
import com.ndd.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/auth" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Inject
	UserService userService;
	
	@Inject
	BookService bookService;

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("login")) {
				String message = request.getParameter("message");
				String alert = request.getParameter("alert");
				if (message != null && alert != null) {
					request.setAttribute("message", resourceBundle.getString(message));
					request.setAttribute("alert", alert);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/views/auth/login.jsp");
				rd.forward(request, response);
			} else if (action.equals("register")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/auth/register.jsp");
				rd.forward(request, response);
			} else if (action.equals("logout")) {
				SessionUtil.getInstance().removeValue(request, "USERMODEL");
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			} else {

			}
		} else {
			List<BookModel> list = bookService.findAll();
			request.setAttribute("model", list);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("login")) {
				// map the data from the request to a UserModel object using FormUtil
				UserModel userModel = FormUtil.toModel(UserModel.class, request);

				userModel = userService.findOneByUsernameAndPassword(userModel.getUsername(), userModel.getPassword(),
						1);
				if (userModel != null) {
					SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
					if (userModel.getRole().getCode().equals("USER")) {
						response.sendRedirect(request.getContextPath() + "/trang-chu");
					} else if (userModel.getRole().getCode().equals("ADMIN")) {
						response.sendRedirect(request.getContextPath() + "/admin-trang-chu");
					}
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/auth?action=login&message=username_password_invalid&alert=danger");
				}
			} else if (action.equals("register")) {

			}
		}
	}

}
