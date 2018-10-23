package com.bitongyun.api;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.bitongyun.utils.RequestClientUtil;

@Controller
public class UploadAPIcontrllor {
	 @RequestMapping("/uploadImageAPI")
	    @ResponseBody
	    public JSONObject uploadImage(@RequestParam(value = "image", required = false) MultipartFile files, HttpServletRequest requesrt,
	                                  HttpServletResponse response) throws IOException {
	        JSONObject json = new JSONObject();
	        String uuid = UUID.randomUUID().toString();
	        uuid = uuid.replaceAll("-", "");
	        String realPath = requesrt.getSession().getServletContext().getRealPath("/");
	        System.out.println(realPath);
	        String path = "/static/upload/images";
	        String fileName = files.getOriginalFilename();
	        String suffix = fileName.substring(fileName.length() - 3);
	        File file = new File(realPath+path,uuid+"."+suffix);
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        files.transferTo(file);
	        json.put("fileName","upload/images/"+uuid+"."+suffix);
	        return json;
	    }
	 
	 @RequestMapping("/uploadVideoAPI")
	    @ResponseBody
	    public JSONObject uploadVideo(@RequestParam(value = "mf", required = false) MultipartFile files, HttpServletRequest requesrt,
	                                  HttpServletResponse response) throws IOException {
	        JSONObject json = new JSONObject();

	        response.setContentType("application/json;charset=utf-8;");
	        if(files==null){
	            json.put("messqge","message");
	            return json;
	        }
	        String uuid = UUID.randomUUID().toString();
	        uuid = uuid.replaceAll("-", "");
	        String realPath = requesrt.getSession().getServletContext().getRealPath("/");
	        System.out.print(realPath);
	        String fileName = files.getOriginalFilename();
	        String suffix = fileName.substring(fileName.length() - 3);
	        String path = "/static/upload/videos";

	        File file = new File(realPath+path,uuid+"."+suffix);
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        files.transferTo(file);
	        String imgPath = null;
	        System.out.print(imgPath);
	        json.put("fileName","upload/video/"+uuid+"."+suffix);
	        Map<String, String> map = new HashMap<String,String>();
	        map.put("message", uuid+"."+suffix);
	        String result = RequestClientUtil.httpRequestToString("http://127.0.0.1:5000/test", "get", map, "null");
	        System.out.println(result);
	        return json;
	    }

}
