package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserDeviceDaoImplTest {

	UserDeviceDaoImpl userdevice = new UserDeviceDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertEquals(new Integer("10001"), userdevice.selectByPrimaryKey(1).getDeviceId());
	}

}
