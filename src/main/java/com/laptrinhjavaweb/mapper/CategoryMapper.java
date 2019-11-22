package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;
/**
 * Class đưa các dữ liệu từ resultSet vào CategoryModel
 * @author hai.nv173089
 *
 */
public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
