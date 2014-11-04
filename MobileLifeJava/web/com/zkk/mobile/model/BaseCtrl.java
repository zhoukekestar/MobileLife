package com.zkk.mobile.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public interface BaseCtrl {
	static final Logger logger = Logger.getLogger(BaseCtrl.class);
	
	
	public abstract void 	setCMD(HttpServletRequest request);
	public abstract String 	getCMD();
}
