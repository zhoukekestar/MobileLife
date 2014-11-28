package com.zkk.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zkk.mobile.model.BaseCtrl;
import com.zkk.mobile.model.BaseMap;
import com.zkk.mobile.server.Server;

@SuppressWarnings("serial")
@WebServlet(name="com_zkk_mobile_servlet_Ctrl", urlPatterns="/ctrl")
public class Ctrl extends HttpServlet {

	private static Logger logger = Logger.getLogger(Ctrl.class);
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// get control action
		BaseCtrl ctrl = null;
		try {
			String className = BaseMap.getClassName(request.getParameter("typeid"));
			ctrl = (BaseCtrl) Class.forName(className).newInstance();
		} catch (Exception e)
		{
			logger.error(e.getMessage());
		}
		ctrl.setCMD(request);
		
		// add to server
		logger.debug("ctrl add:[" + ctrl.getCMD() + "]");
		Server.msgList.add(ctrl.getCMD());
	
		// return to client
		String callback = request.getParameter("callback");
		PrintWriter out = response.getWriter();
		out.println(callback + "({\"msg\":\"ok\"})");
		out.flush();
		out.close();
	}
}
