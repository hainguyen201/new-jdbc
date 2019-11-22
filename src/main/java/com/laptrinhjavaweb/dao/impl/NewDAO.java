package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.NewsModel;

/**
 * class thao tác dữ liệu bảng news
 * 
 * @author hai.nv173089
 *
 */
public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {
	/**
	 * Hàm lấy thông tin từ news có category=categoryid
	 */
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid= ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		//String sql = " insert into news (title, content, categoryid) values(?, ?, ?)";
		 StringBuilder sql=new StringBuilder("insert into news (");
		 sql.append("title,content, thumbnail, shortdescription, categoryid, createddate,");
		 sql.append("createdby) values (?,?,?,?,?,?,?)");
		 return insert(sql.toString(), 
				 newsModel.getTitle(),
				 newsModel.getContent(),
				 newsModel.getThumbnail(),
				 newsModel.getShortdescription(),
				 newsModel.getCategoryid(),
				 newsModel.getCreateddate(),
				 newsModel.getCreatedBy());
	}

	@Override
	public void delete(long id) {
		String sql="delete from news where id=?";
		update(sql, id);
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where id= ?";
		List<NewsModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null: news.get(0);
	}

	@Override
	public void update(NewsModel updateNew) {
		StringBuilder sql=new StringBuilder("UPDATE news SET title= ?, thumbnail=?,");
		sql.append(" shortdescription=?, content=?, categoryid=?,");
		sql.append("createddate=?, createdby=?, modifieddate=?,modifiedby=? where id=?");
		update(sql.toString(),
				updateNew.getTitle(), 
				updateNew.getThumbnail(), 
				updateNew.getShortdescription(),
				updateNew.getContent(), 
				updateNew.getCategoryid(), 
				updateNew.getCreateddate(), 
				updateNew.getModifieDate(),
				updateNew.getModifiedBy(),
				updateNew.getCreatedBy(), 
				updateNew.getId());			
	}

	@Override
	public List<NewsModel> findAll() {
		String sql = "select * from news";
		return query(sql, new NewMapper());
	}
}
