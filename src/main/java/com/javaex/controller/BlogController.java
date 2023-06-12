package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	//블로그 접속
	@RequestMapping(value = "/blog/{id}")
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println("UesrController.logout()");
		
		BlogVo blogVo =blogService.getBlog("id");
		model.addAttribute("blog", blogVo);
		
		return "";
	}
}
