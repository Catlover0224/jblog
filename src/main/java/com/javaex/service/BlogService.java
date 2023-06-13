package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	String saveDir = "C:\\javaStudy\\upload";

	@Autowired
	private BlogDao blogDao;

	// 블로그 만들기
	public void createBlog(String id, String userName) {
		System.out.println("BlogService.createBlog()");
		System.out.println("BlogService.id : " + id);

		String title = userName + "의 블로그 입니다.";
		Map<String, String> blog = new HashMap<>();
		blog.put("id", id);
		blog.put("BLOGTITLE", title);

		blogDao.createBlog(blog);
	}

	// 블로그 가져오기
	public BlogVo getBlog(String id) {
		System.out.println("BlogService.getBlog()");
		System.out.println("BlogService.id : " + id);

		BlogVo blogVo = blogDao.getBlog(id);

		return blogVo;
	}

	public BlogVo update(MultipartFile file, String id, String blogTitle) {
		System.out.println("BlogService.getBlog()");
		// 원파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName : " + orgName);

		// 확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName : " + exName);

		// 저장파일 이름
		String savaName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("savaName : " + savaName);

		// 파일패스
		String filePath = saveDir + "\\" + savaName;
		System.out.println("filePath : " + filePath);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize : " + fileSize);

		// 파일 업로드(하드디스크에 저장)
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BlogVo blogVo = new BlogVo(id, blogTitle, savaName);
		System.out.println(blogVo);
		
		blogDao.update(blogVo);
		
		return blogVo;
	}

}
