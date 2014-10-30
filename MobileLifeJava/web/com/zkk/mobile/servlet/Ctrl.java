package com.zkk.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD:MobileLifeJava/web/com/zkk/mobile/servlet/Ctrl.java
import com.zkk.mobile.config.DevConfig;
import com.zkk.mobile.model.Control;
import com.zkk.mobile.server.Server;
=======
import com.zkk.mobile.model.Control;
import com.zkk.mobile.server.MainServer;
>>>>>>> 0b4bd7341c7fc2818aca4df8a5f04307a3d7d7bf:MobileLifeJava/src/com/zkk/mobile/servlet/Ctrl.java


@SuppressWarnings("serial")
@WebServlet(name="com_zkk_mobile_servlet_Ctrl", urlPatterns="/ctrl")
public class Ctrl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Control ctrl = new Control();
		ctrl.type = request.getParameter("type");
		ctrl.id = Integer.valueOf(request.getParameter("id"));
		ctrl.action =	request.getParameter("action");
		
<<<<<<< HEAD:MobileLifeJava/web/com/zkk/mobile/servlet/Ctrl.java
		System.out.println(getCmd(ctrl));
		Server.msgList.add(getCmd(ctrl));
=======
		//System.out.println(ctr.toString());
		MainServer.msgList.add(ctr.toString());
>>>>>>> 0b4bd7341c7fc2818aca4df8a5f04307a3d7d7bf:MobileLifeJava/src/com/zkk/mobile/servlet/Ctrl.java
		
		String callback = request.getParameter("callback");
		PrintWriter out = response.getWriter();
		out.println(callback + "({\"msg\":\"ok\"})");
		out.flush();
		out.close();
	}	
	
	private static String getCmd(Control ctrl)
	{
		String cmd = DevConfig.ledRoot + " " + String.valueOf(ctrl.id - 1);
		if (ctrl.action.equals("off"))
			cmd += " 0";
		else
			cmd += " 1";
		return cmd;
	}
}
