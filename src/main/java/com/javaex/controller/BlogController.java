package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
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
	//블로그 관리창(Basic)
	@RequestMapping(value = "/blog/{id}/admin/basic",method = {RequestMethod.GET,RequestMethod.POST})
	public String blogAdminBasic(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController.blogAdminBasic()");
		
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blog", blogVo);
		
		return "/blog/admin/blog-admin-basic";
	}
	//블로그 관리창(category)
	@RequestMapping(value = "/blog/{id}/admin/category", method = {RequestMethod.GET,RequestMethod.POST})
	public String blogAdminCategory(@PathVariable("id") String id,Model model) {
		System.out.println("BlogController.blogAdminCategory()");
		
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blog", blogVo);
		List<CategoryVo> cateList = categoryService.getCate(id);
		
		model.addAttribute("cate",cateList);
		
		return "/blog/admin/blog-admin-cate";
	}
	
	//블로그 수정
	@RequestMapping(value = "/blog/{id}/admin/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogAdminUpdate(@RequestParam("blogTitle") String blogTitle,
	                              @RequestParam("file") MultipartFile file,
	                              @PathVariable("id") String id,
	                              Model model) {
	    System.out.println("BlogController.blogAdminUpdate()");
	    
	    BlogVo blogVo = blogService.update(file, id, blogTitle);
	    model.addAttribute("blog", blogVo);
	    
	    return "redirect:/blog/"+id;
	}

}
