package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

	@Autowired
	SqlSession session;
	
	public void createcategory(String id) {
		System.out.println("CategoryService.createcategory()");
		
		session.insert("category.createcategory",id);
		
	}

}
