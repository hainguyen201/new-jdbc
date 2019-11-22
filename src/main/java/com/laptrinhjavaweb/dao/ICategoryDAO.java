package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;
/**
 * interface thao tác dữ liệu bảng category
 * @author hai.nv173089
 *
 */
public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	/**
	 * hàm lấy tất cả dữ liệu bảng category
	 * @return
	 */
	List<CategoryModel> findAll();
	
	

}
