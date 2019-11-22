package com.laptrinhjavaweb.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private Date createddate;
	private Date modifieDate;
	private String createdBy;
	private String modifiedBy;
	private long[] ids;
	private List<T> listResult=new ArrayList<>();	
	private int page;
	private int totalitem;
	private int maxpageItem;
	private int totalPage;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalitem() {
		return totalitem;
	}
	public void setTotalitem(int totalitem) {
		this.totalitem = totalitem;
	}
	public int getMaxpageItem() {
		return maxpageItem;
	}
	public void setMaxpageItem(int maxpageItem) {
		this.maxpageItem = maxpageItem;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getModifieDate() {
		return modifieDate;
	}
	public void setModifieDate(Date modifieDate) {
		this.modifieDate = modifieDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}
