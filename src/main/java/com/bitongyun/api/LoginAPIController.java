package com.bitongyun.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitongyun.bean.User;
import com.bitongyun.utils.MybatisUtils;

@Controller
public class LoginAPIController {

	@RequestMapping("loginAPI")
	@ResponseBody
	public Map<String,String> login(@RequestBody User user){
			MybatisUtils myUtils = new MybatisUtils();
			SqlSession session = myUtils.getSession();
			String statement5 = "com.bitongyun.userMapper.findUser";
			String result = null;
			Map<String, String> map = new HashMap<String, String>();
			User find2 = session.selectOne(statement5, new User(user.getUser_name(), user.getPassword()));
			if (find2 == null) {
				result = "fail";
				map.put("msg", result);
			} else {
				result = "success";
				map.put("msg", result);
			}	
				return map;	
	}
}
