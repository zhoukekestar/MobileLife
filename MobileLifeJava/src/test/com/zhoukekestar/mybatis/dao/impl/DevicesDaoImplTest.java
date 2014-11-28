package com.zhoukekestar.mybatis.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.zhoukekestar.mybatis.dao.impl.DevicesDaoImpl;

public class DevicesDaoImplTest {

	private DevicesDaoImpl devicesDaoImpl = new DevicesDaoImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertEquals("移动你的生活测试版", devicesDaoImpl.selectByPrimaryKey(10001).getDeviceAlias());
	}

}
