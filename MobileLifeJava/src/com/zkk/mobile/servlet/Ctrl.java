package com.zkk.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zkk.mobile.model.Control;
import com.zkk.mobile.server.MainServer;


@SuppressWarnings("serial")
@WebServlet(name="com_zkk_mobile_servlet_Ctrl", urlPatterns="/ctrl")
public class Ctrl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Control ctr = new Control();
		ctr.type = request.getParameter("type");
		ctr.id = request.getParameter("id");
		ctr.action =	request.getParameter("action");
		
		//System.out.println(ctr.toString());
		MainServer.msgList.add(ctr.toString());
		
		String callback = request.getParameter("callback");
		PrintWriter out = response.getWriter();
		out.println(callback + "({\"msg\":\"ok\"})");
		out.flush();
		out.close();
	}	
}
