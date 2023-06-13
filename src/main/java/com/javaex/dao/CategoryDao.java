package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	SqlSession session;
	
	public void createcategory(String id) {
		System.out.println("CategoryService.createcategory()");
		
		session.insert("category.createcategory",id);
		
	}

	public List<CategoryVo> getCate(String id) {
		System.out.println("CategoryService.getCate()");
		
		List<CategoryVo> cateList = session.selectList("category.getCate",id);
		System.out.println(cateList);
		
		return cateList;
	}

}
