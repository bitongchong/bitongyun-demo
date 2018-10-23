package com.bitongyun.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bitongyun.controller.LoginController;

public class MybatisUtils {
	public SqlSession getSession() {
		String resource = "mybatis-config.xml";
		InputStream iStream = LoginController.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session = factory.openSession(true);
		return session;
	}
}
