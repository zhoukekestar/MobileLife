package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LedLogDaoImplTest {
	
	private LedLogDaoImpl led = new LedLogDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		
		assertEquals(null, led.selectByPrimaryKey(1));
	}

}
