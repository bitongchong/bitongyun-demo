package com.bitongyun.controller;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bitongyun.bean.User;
import com.bitongyun.utils.MybatisUtils;

	@Controller
	@SessionAttributes("current_user")
	public class LoginController {
		
		@RequestMapping("to_login")
		public String toLogin() {
			return "login";
		}
		
		@RequestMapping(value="do_login")
		public String doLogin(ModelMap map,@RequestParam("user_name")String user_name, @RequestParam("password")String password){
				MybatisUtils myUtils = new MybatisUtils();
				SqlSession session = myUtils.getSession();
				String statement5 = "com.bitongyun.userMapper.findUser";
				String result = null;
				User user = new User(user_name,password);
				User find2 = session.selectOne(statement5, new User(user.getUser_name(), user.getPassword()));
				if (find2 == null) {
					result = "login";
				} else {
					result = "upload";
					map.addAttribute("current_user", user);
				}	
					return result;	
		}
}
