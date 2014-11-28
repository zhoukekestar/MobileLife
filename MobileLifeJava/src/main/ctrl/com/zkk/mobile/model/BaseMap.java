package com.zkk.mobile.model;

import java.util.HashMap;
import java.util.Map;

public class BaseMap {
	private static Map<String, String> classMap;	
	static{
		classMap = new HashMap<String, String>();
		classMap.put("1", "com.zkk.mobile.model.LedCtrl");
	}
	public static String getClassName(String typeid) {
		return classMap.get(typeid);
	}

}
