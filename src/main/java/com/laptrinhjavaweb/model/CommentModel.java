package com.laptrinhjavaweb.model;

public class CommentModel extends AbstractModel<CommentModel>{
	private String content;
	private Long userid;
	private Long newid;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getNewid() {
		return newid;
	}
	public void setNewid(Long newid) {
		this.newid = newid;
	}
	
}
