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

	public List<CategoryVo> getCate(String id) {
		System.out.println("CategoryService.getCate()");
		
		List<CategoryVo> cateList =categoryDao.getCate(id);
		
		return cateList;
	}

}
