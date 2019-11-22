package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {
	@Inject
	private INewService newService;

	private static final long serialVersionUID = -915988021506484384L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//tạo đối tượng mapper dùng để chuyển một model về dạng json
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt mà không bị lỗi font
		req.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		resp.setContentType("application/json");
		// chuyển từ String json về Model
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newsModel = newService.save(newsModel);
		// đưa dữ liệu vào response dạng json sử dụng mapper
		mapper.writeValue(resp.getOutputStream(), newsModel);
	}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		ObjectMapper mapper=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel updateNew=HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		updateNew=newService.update(updateNew);
		mapper.writeValue(resp.getOutputStream(), updateNew);
		/*
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(json);
		 */		
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel deleteNew=HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newService.delete(deleteNew.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
