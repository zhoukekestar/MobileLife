package com.zhoukekestar.mybatis.zzz.test;

import java.util.List;

import com.zhoukekestar.mybatis.auto.model.User;
import com.zhoukekestar.mybatis.auto.model.UserExample;
import com.zhoukekestar.mybatis.dao.impl.UserDaoImpl;

public class App {
	public static void main(String[] args) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserExample example = new UserExample();
		example.createCriteria().andIdBetween(5, 30);
		example.or().andUserageEqualTo(100);
		List<User> list = userDaoImpl.selectByExample(example);
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
}
