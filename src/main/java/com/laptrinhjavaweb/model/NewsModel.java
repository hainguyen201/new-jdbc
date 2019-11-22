package com.laptrinhjavaweb.model;

public class NewsModel extends AbstractModel<NewsModel>{
	private String title;
	private String thumbnail;
	private String shortdescription;
	private Long categoryid;
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdesciption(String shortdesciption) {
		this.shortdescription = shortdesciption;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
	

}
