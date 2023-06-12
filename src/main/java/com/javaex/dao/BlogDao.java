package com.javaex.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession session;
	
	//블로그 생성
	public void createBlog(Map<String, String> blog) {
		System.out.println("BlogDao.createBlog()");
		
		session.insert("blog.createblog",blog);
	}

	//블로그 가져오기
	public BlogVo getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

}
