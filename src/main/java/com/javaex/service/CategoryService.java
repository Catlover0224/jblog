package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public void createcategory(String id) {
		System.out.println("CategoryService.createcategory()");
		System.out.println(id);
		
		categoryDao.createcategory(id);
	}

	//카테고리 리스트 출력
	public List<CategoryVo> getCateList(String id) {
		System.out.println("CategoryService.getCate()");
		
		List<CategoryVo> cateList =categoryDao.getCateList(id);
		
		return cateList;
	}

	//카테고리 등록
	public int categoryInsert(CategoryVo categoryVo) {
		System.out.println("CategoryService.categoryInsert()");
		
		categoryDao.categoryInsert(categoryVo);
		int no =categoryDao.getCateNo(categoryVo.getId());
		
		return no;
	}

}
