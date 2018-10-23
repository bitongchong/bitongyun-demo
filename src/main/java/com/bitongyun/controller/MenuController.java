package com.bitongyun.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bitongyun.bean.User;
import com.bitongyun.utils.MybatisUtils;

@Controller
@SessionAttributes(value={"current_user","video_list","photo_list",
		"zip_list","all_list","music_list","document_list"})
public class MenuController {
	@RequestMapping("showVideo")
	public static String showVideo(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findVideo";
		List<User> video_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("video_list",video_list);
	        if(model.containsAttribute("video_list")){
	            return "video";
	        }
	        return "error";
	}
	
	@RequestMapping("showPhoto")
	public static String showImage(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findPhoto";
		List<User> photo_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("photo_list",photo_list);
	        if(model.containsAttribute("photo_list")){
	            return "photo";
	        }
	        return "error";
	}
	
	@RequestMapping("showDoc")
	public static String showDoc(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findDoc";
		List<User> document_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("document_list",document_list);
	        if(model.containsAttribute("document_list")){
	            return "document";
	        }
	        return "error";
	}
	
	@RequestMapping("showZip")
	public static String showZip(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findZip";
		List<User> zip_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("zip_list",zip_list);
	        if(model.containsAttribute("zip_list")){
	            return "zip";
	        }
	        return "error";
	}
	
	@RequestMapping("showOther")
	public static String showOther(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findOther";
		List<User> other_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("other_list",other_list);
	        if(model.containsAttribute("other_list")){
	            return "other";
	        }
	        return "error";
	}
	
	@RequestMapping("showMusic")
	public static String showMusic(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findMusic";
		List<User> music_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("music_list",music_list);
	        if(model.containsAttribute("music_list")){
	            return "music";
	        }
	        return "error";
	}
	
	
	@RequestMapping("showAll")
	public static String showAll(ModelMap model,@ModelAttribute("current_user")User user) {
		MybatisUtils mybatisUtils = new MybatisUtils();
		SqlSession sqlSession = mybatisUtils.getSession();
		String user_name = user.getUser_name();
		String statement = "com.bitongyun.fileMapper.findAll";
		List<User> all_list = sqlSession.selectList(statement,user_name);
	    model.addAttribute("all_list",all_list);
	        if(model.containsAttribute("all_list")){
	            return "all";
	        }
	        return "error";
	}
}