package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewsModel;

/**
 * Class đưa các dữ liệu từ resultSet vào NewModel
 * 
 * @author hai.nv173089
 *
 */
public class NewMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryid(resultSet.getLong("categoryid"));
			news.setShortdesciption(resultSet.getString("shortdescription"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setCreatedBy(resultSet.getString("createdby"));
			news.setCreateddate(resultSet.getDate("createddate"));
			if (resultSet.getDate("modifieddate") != null) {
				news.setModifieDate(resultSet.getDate("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
