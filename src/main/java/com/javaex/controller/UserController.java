package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.UserService;
import com.javaex.vo.JsonResult;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	//로그아웃
	@RequestMapping(value = "/user/logout", method= {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UesrController.logout()");
		
		session.invalidate();
		return "redirect:/";
	}

	// 로그인
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo vo, HttpSession session) {
		System.out.println("UesrController.login()");

		UserVo user = userService.login(vo);
		if (user != null) {
			session.setAttribute("user", user);
			System.out.println("로그인성공");
			System.out.println(user);
			return "redirect:/";
		} else {
			System.out.println("로그인실패");
			return "/user/loginForm";
		}
	}

	// 회원가입 id체크
	@ResponseBody
	@RequestMapping(value = "/user/idcheck", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult idCheck(@RequestParam("id") String id) {
		System.out.println("UesrController.idCheck()");
		System.out.println(id);

		boolean data = userService.idCheck(id);

		JsonResult jsonResult = new JsonResult();
		jsonResult.success(data);

		return jsonResult;
	}

	// 회원가입
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("UserController.join()");

		// 유저 생성
		userService.join(vo);
		// 유저 블로그 생성
		blogService.createBlog(vo.getId(), vo.getUserName());
		// 기본카테고리 생성
		categoryService.createcategory(vo.getId());

		return "/user/joinSuccess";
	}

	// 회원가입창
	@RequestMapping("/user/joinForm")
	public String joinForm() {
		System.out.println("UserController.joinForm()");

		return "/user/joinForm";
	}

	// 로그인창
	@RequestMapping("/user/loginForm")
	public String loginForm() {
		System.out.println("UserController.loginForm()");

		return "/user/loginForm";
	}
}
