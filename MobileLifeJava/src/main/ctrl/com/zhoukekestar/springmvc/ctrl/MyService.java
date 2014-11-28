package com.zhoukekestar.springmvc.ctrl;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public String str = "myService";
	
	public String a(String arg)
	{
		System.out.println("this is a");
		return "a";
	}
	
	public String b(String arg1, String arg2)
	{
		System.out.println("this is b");
		return "b";
	}
	
	public void c() throws Exception {
		System.out.println("this is c");
		
		throw new Exception("c-error-by-zkk");
	}
}
