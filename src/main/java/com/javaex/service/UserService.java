package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao; 

	public void join(UserVo vo) {
		System.out.println("UserService.join()");
		
		userDao.join(vo);
	}

	//아이디 체크
	public boolean idCheck(String id) {
		System.out.println("UserService.idCheck()");
		UserVo vo = userDao.idCheck(id);
		boolean result;
		
		if(vo==null) {
			result=true;
		}else {
			result=false;
		}
		System.out.println("idCheck."+result);
		
		return result;
	}

	//로그인
	public UserVo login(UserVo vo) {
		System.out.println("UserService.login()");
		
		UserVo uVo =userDao.login(vo);
		
		return uVo;
	}


}
