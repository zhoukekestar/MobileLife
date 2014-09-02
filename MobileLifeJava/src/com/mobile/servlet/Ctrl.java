package com.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.model.Control;
import com.mobile.model.Data;
import com.sun.corba.se.pept.transport.ContactInfo;


@SuppressWarnings("serial")
@WebServlet(name="com_mySSH_servlet_Ctrl", urlPatterns="/ctrl")
public class Ctrl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Control ctr = new Control();
		ctr.type = request.getParameter("type");
		ctr.id = request.getParameter("id");
		ctr.action =	request.getParameter("action");
		
		//System.out.println(ctr.toString());
		Data.msgList.add(ctr.toString());
		
		Data.runServer();
		
		String callback = request.getParameter("callback");
		PrintWriter out = response.getWriter();
		out.println(callback + "({\"msg\":\"ok\"})");
		out.flush();
		out.close();
	}	
}
