package com.zhoukekestar.springmvc._config;

import javax.servlet.annotation.WebServlet;

import org.springframework.web.servlet.DispatcherServlet;

@SuppressWarnings("serial")
@WebServlet(name="mydispathcherservlet", urlPatterns="/", loadOnStartup=1)
public class ConfigForServlet extends DispatcherServlet {

	public ConfigForServlet()
	{
		super.setContextConfigLocation("classpath:/com/zhoukekestar/springmvc/_config/springMVC.xml");
		System.out.println("MyDispacherServlet init ok!");
	}
	
}
