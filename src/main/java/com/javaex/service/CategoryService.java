package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public void createcategory(String id) {
		System.out.println("CategoryService.createcategory()");
		System.out.println(id);
		
		categoryDao.createcategory(id);
	}

}
