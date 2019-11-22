package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap" })
public class HomeController extends HttpServlet {
	// servlet weld quản lý beans
	// mồi lần request sẽ tạo một NewServlet
	// khi dùng servlet weld thì không cần làm điều đó (@Inject)
	@Inject
	private ICategoryService categoryService;
	private static final long serialVersionUID = 2686801510274002166L;

	/**
	 * Controller lấy dữ liệu
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rdDispatcher = request.getRequestDispatcher("views/login.jsp");
			rdDispatcher.forward(request, response);
		} else if (action != null && action.equals("logout")) {

		} else {
			request.setAttribute("categories", categoryService.findAll());
			RequestDispatcher rdDispatcher = request.getRequestDispatcher("views/web/home.jsp");
			rdDispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model=new UserModel();
			
		}
	}
}
