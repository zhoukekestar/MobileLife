package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModelsDaoImplTest {

	private ModelsDaoImpl model = new ModelsDaoImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertEquals("Simple model", model.selectByPrimaryKey(1).getModelAlias());
	}

}
