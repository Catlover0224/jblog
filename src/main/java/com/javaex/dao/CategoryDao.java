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

	public List<CategoryVo> getCateList(String id) {
		System.out.println("CategoryService.getCate()");
		
		List<CategoryVo> cateList = session.selectList("category.getCateList",id);
		System.out.println(cateList);
		
		return cateList;
	}

	public void categoryInsert(CategoryVo categoryVo) {
		System.out.println("CategoryService.categoryInsert()");
		
		session.insert("category.insert",categoryVo);
		
	}

	public int getCateNo(String id) {
		System.out.println("CategoryService.getCateNo()");
		
		int no =session.selectOne("category.getCateNo", id);
		System.out.println(no);
		
		return no;
	}

}
