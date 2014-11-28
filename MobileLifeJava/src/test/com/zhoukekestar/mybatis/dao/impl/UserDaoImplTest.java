package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {

	UserDaoImpl user = new UserDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertEquals("测试账号", user.selectByPrimaryKey(1).getNickname());
	}

}
