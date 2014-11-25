package com.zhoukekestar.mybatis.zzz.test;

import java.util.List;

import com.zhoukekestar.mybatis.auto.model.Devices;
import com.zhoukekestar.mybatis.auto.model.User;
import com.zhoukekestar.mybatis.auto.model.UserExample;
import com.zhoukekestar.mybatis.dao.impl.DevicesDaoImpl;

public class App {
	public static void main(String[] args) {
		DevicesDaoImpl devicesDaoImpl = new DevicesDaoImpl();
		Devices devices = devicesDaoImpl.selectByPrimaryKey(10001);
		System.out.println(devices.getDeviceAlias());
		
	}
}
