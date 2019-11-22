package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
/**
 * interface thao tác dữ liệu bảng news
 * @author hai.nv173089
 *
 */
public interface INewDAO extends GenericDAO<NewsModel>{
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);	
	void delete(long id);
	NewsModel findOne(Long id);
	void update(NewsModel updateNew);
	List<NewsModel> findAll();
}
