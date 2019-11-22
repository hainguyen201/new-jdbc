package com.laptrinhjavaweb.service.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDAO newDao;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModels) {
		newModels.setCreateddate(new Date(System.currentTimeMillis()));
		newModels.setCreatedBy("");
		Long newId=newDao.save(newModels);
		return newDao.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNew) {
		NewsModel oldNew=newDao.findOne(updateNew.getId());
		updateNew.setCreateddate(oldNew.getCreateddate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifieDate(new Date(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll() {
		return newDao.findAll();
	}

}
