package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;
/**
 * Class thao tác với bảng category
 * @author hai.nv173089
 *
 */
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	/**
	 * hàm lấy toàn bộ dữ liệu từ bảng category
	 */
	@Override
	public List<CategoryModel> findAll() {
		
		String sql = "select * from category";
		return query(sql, new CategoryMapper()); 

	}

	

}
