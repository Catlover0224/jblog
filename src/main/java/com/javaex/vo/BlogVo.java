package com.javaex.vo;

public class BlogVo {
	//필드
	private String id;
	private String blogTitle;
	private String logoFile;
	
	//생성자
	public BlogVo() {
		super();
	}
	
	public BlogVo(String id, String blogTitle, String logoFile) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}
	//게터세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	//toString()
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}
	
}
