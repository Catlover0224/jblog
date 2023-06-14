package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;

	public void postInsert(PostVo postVo) {
		System.out.println("PostService.postInsert()");
		
		postDao.postInsert(postVo);
		
	}

	public List<PostVo> getPostList() {
		System.out.println("PostService.getPostList()");
		
		List<PostVo> postList = postDao.getPostList();
		return postList;
	}

	public PostVo getPost() {
		System.out.println("PostService.getPost()");
		
		PostVo postVo = postDao.getPost();
		return postVo;
	}
}
