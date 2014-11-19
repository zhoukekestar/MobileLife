package com.zkk.mobile.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class StartServer implements ServletContextListener {

	private static Logger logger = Logger.getLogger(StartServer.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Server.runServer();
		logger.info("Server init...");
	}

}
