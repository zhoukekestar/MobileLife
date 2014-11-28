package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OneModelDaoImplTest {

	OneModelDaoImpl one = new OneModelDaoImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertEquals(new Integer(2), one.selectByPrimaryKey(3).getModelId());
	}

}
