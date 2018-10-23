package com.bitongyun.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bitongyun.bean.User;
import com.bitongyun.utils.MybatisUtils;

@Controller
public class RegisterController {
	@RequestMapping("to_register")
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping(value="do_register",method=RequestMethod.POST)
	public String register(User user){
		MybatisUtils myUtils = new MybatisUtils();
		SqlSession session = myUtils.getSession();
		String statement3 = "com.bitongyun.userMapper.addUser";
		String statement4 = "com.bitongyun.userMapper.findUser2";
		User find = session.selectOne(statement4, new User(user.getUser_name(), user.getPassword()));
		Map<String,String> map = new HashMap<String,String>();

		if (find == null) {
			int update = session.insert(statement3, new User(user.getUser_name(), user.getPassword()));
			System.out.println(update);
			map.put("msg", "success");
			return "login";
		} else {
			System.out.println("已经存在");
			//这儿也可以添加原因
			map.put("msg", "fail");
			return "register";
		}
	}
}
