package com.zkk.mobile.model;

public class Control {
	
	public String type = "";
	public int id;
	public String action = "";
	
	public String toString()
	{
		return "type:" + type + ",id:" + String.valueOf(id) + ",action:" + action;
	}
}
