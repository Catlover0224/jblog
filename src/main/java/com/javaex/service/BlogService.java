package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao; 
	
	//블로그 만들기
	public void createBlog(String id, String userName) {
		System.out.println("BlogService.createBlog()");
		System.out.println("BlogService.id : "+id);
		
		String title = userName+"의 블로그 입니다.";
		Map<String, String> blog = new HashMap<>();
		blog.put("id",id);
		blog.put("BLOGTITLE", title);
		
		blogDao.createBlog(blog);
	}

	//블로그 가져오기
	public BlogVo getBlog(String id) {
		System.out.println("BlogService.getBlog()");
		System.out.println("BlogService.id : "+id);
		
		BlogVo blogVo = blogDao.getBlog(id);
		
		return blogVo;
	}

}
