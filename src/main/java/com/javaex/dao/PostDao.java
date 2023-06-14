package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	@Autowired
	private SqlSession session;

	public void postInsert(PostVo postVo) {
		System.out.println("PostDao.postInsert()");
		
		session.insert("post.insert", postVo);
		
	}

	public List<PostVo> getPostList() {
		System.out.println("PostDao.getPostList()");
		
		List<PostVo> postList = session.selectList("post.getPostList");
		System.out.println(postList);
		
		return postList;
	}

	public PostVo getPost() {
		System.out.println("PostDao.getPost()");
		
		PostVo postVo = session.selectOne("post.getPost");
		System.out.println(postVo);
		
		return postVo;
	}
}
