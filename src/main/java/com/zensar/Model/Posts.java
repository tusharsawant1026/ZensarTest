package com.zensar.Model;


public class Posts {

	private long userId;
	private long id;
	private String title;
	private String body;
	
	
	
	
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Posts(long userId, long id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Posts [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
	
}
