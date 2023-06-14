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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.JsonResult;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;
	
	//블로그 접속
	@RequestMapping(value = "/blog/{id}")
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController.blogMain()");
		
		//블로그 정보가져오기
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blog", blogVo);	
		//카테고리 리스트 가져오기
		List<CategoryVo> cateList = categoryService.getCateList(id);
		model.addAttribute("cate",cateList);
		//채신 페이지 가져오기
		PostVo postVo = postService.getPost();
		model.addAttribute("postVo",postVo);
		//포스트 리스트 가져오기
		List<PostVo> postList = postService.getPostList();
		model.addAttribute("post",postList);
		
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
		List<CategoryVo> cateList = categoryService.getCateList(id);
		
		model.addAttribute("cate",cateList);
		
		return "/blog/admin/blog-admin-cate";
	}
	
	//블로그 관리창(write)
	@RequestMapping(value = "/blog/{id}/admin/writeForm")
	public String blogAdminWrite(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController.blogAdminWrite()");
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blog", blogVo);
		
		List<CategoryVo> cateList = categoryService.getCateList(id);
		model.addAttribute("cate",cateList);
		
		return "/blog/admin/blog-admin-write";
	}
	
	//포스트 등록
	@RequestMapping(value =  "/blog/{id}/admin/postInsert", method = {RequestMethod.GET, RequestMethod.POST})
	public String postInsert(@PathVariable("id") String id,
							 @RequestParam("postTitle") String postTitle, 
							 @RequestParam("cateNo") int cateNo,
							 @RequestParam("postContent") String postContent) { 
		System.out.println("BlogController.postInsert()");
		
		PostVo postVo=new PostVo(0, cateNo, postTitle, postContent, null);
		System.out.println(postVo);
		
		postService.postInsert(postVo);
		
		
		return "redirect:/blog/"+id;
	}
	
	//카테고리 등록
	@ResponseBody
	@RequestMapping(value = "/blog/{id}/admin/categoryInsert", method = {RequestMethod.GET,RequestMethod.POST})
	public CategoryVo categoryInsert(@PathVariable("id") String id,
									@RequestParam("cateName") String cateName,
									@RequestParam("description") String description) {
		System.out.println("BlogController.categoryInsert()");
		System.out.println(cateName);
		System.out.println(description);
		
		CategoryVo categoryVo =new CategoryVo(0, id, cateName, description, null);
		int no =categoryService.categoryInsert(categoryVo);
		categoryVo.setCateNo(no);
		System.out.println(categoryVo);
		
		return categoryVo;
	}
	
	//블로그 수정
	@RequestMapping(value = "/blog/{id}/admin/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogAdminUpdate(@RequestParam(value = "file") MultipartFile file,
								  @RequestParam("blogTitle") String blogTitle,
	                              @PathVariable("id") String id,
	                              Model model) {
	    System.out.println("BlogController.blogAdminUpdate()");
	    System.out.println(file);
	    
	    BlogVo blogVo = blogService.update(file, id, blogTitle);
	    model.addAttribute("blog", blogVo);
	    
	    return "redirect:/blog/"+id;
	}

}
