package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	//블로그 접속
	@RequestMapping(value = "/blog/{id}")
	public String blogMain(@PathVariable("id") String id, Model model,HttpSession session) {
		System.out.println("BlogController.blogMain()");
		
		BlogVo blogVo = blogService.getBlog(id);
		UserVo userVo = (UserVo)session.getAttribute("user");
		System.out.println(userVo);
		model.addAttribute("blog", blogVo);
		
		
		
		return "/blog/blog-main";
	}
}
