package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newModels);
	NewsModel update(NewsModel updateNew);
	void delete (long[] ids);
	List<NewsModel> findAll();
}
