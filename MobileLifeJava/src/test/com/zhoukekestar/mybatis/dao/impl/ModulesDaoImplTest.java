package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModulesDaoImplTest {

	private ModulesDaoImpl module = new ModulesDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertEquals("/home/bin/led", module.selectByPrimaryKey(1).getModulePath());
	}

}
