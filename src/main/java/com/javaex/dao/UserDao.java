package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession session;
	
	//회원가입
	public void join(UserVo vo) {
		System.out.println("UserDao.join()");
		System.out.println(vo);
		
		session.insert("user.join",vo);
	}

	//아이디 체크
	public UserVo idCheck(String id) {
		System.out.println("UserDao.idCheck()");
		
		UserVo vo = session.selectOne("user.idCheck", id);
		System.out.println(vo);
		
		return vo;
	}

	//로그인
	public UserVo login(UserVo vo) {
		System.out.println("UserDao.login()");
		
		UserVo uVo=session.selectOne("user.login",vo);
		
		return uVo;
	}

}
