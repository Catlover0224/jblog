package com.javaex.vo;

import java.util.Date;

public class CategoryVo {
	// 필드
	private int cateNo;
	private String id;
	private String cateName;
	private String description;
	private Date regDate;

	// 생성자, getter 및 setter 메서드 등 필요한 코드를 추가할 수 있습니다.
	public CategoryVo() {
		super();
	}

	public CategoryVo(int cateNo, String id, String cateName, String description, Date regDate) {
		super();
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}

	// getter 및 setter
	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	// toString()
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}

}
