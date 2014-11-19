package com.zkk.mobile.model;

import javax.servlet.http.HttpServletRequest;

import com.zkk.mobile.config.DevConfig;

public class LedCtrl implements BaseCtrl {
	private int id;
	private int switchNum;
	
	@Override
	public String getCMD() {
		if (id > 4 || id < 1)
		{
			logger.error("id:[" + id + "] error");
			return "";
		}
		if (switchNum != 0 && switchNum != 1)
		{
			logger.error("switchNum:[" + switchNum + "] error");
			return "";
		}
		String cmd = DevConfig.ledRoot + " " + String.valueOf(this.id - 1);
		cmd += " " + String.valueOf(switchNum);
		return cmd;
	}

	@Override
	public void setCMD(HttpServletRequest request) {
		id = Integer.valueOf(request.getParameter("id"));
		switchNum = Integer.valueOf(request.getParameter("switchNum"));
	}
	
}
