package com.zhoukekestar.springmvc.ctrl;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoukekestar.springmvc.bean.Greeting;

@Controller
@RequestMapping("/spring")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private Greeting greeting;
    @Autowired
    private MyService myService;
    
    @RequestMapping(value="/restful/{bid}", method=RequestMethod.GET)
    @ResponseBody
    public Greeting greeting(@PathVariable("bid")String name) {
    	
    	System.out.println(name);
    	System.out.println(greeting.getContent());
    	return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/aop/a")
    @ResponseBody
    public String aopA()
    {
    	System.out.println("a-begin-----------------");
    	
    	myService.a("hi");
    	System.out.println("a-end--------------------");
    	return "hi-a";
    }
    
    @RequestMapping("/aop/b")
    @ResponseBody
    public String aopB()
    {
    	System.out.println("b-begin-------------------");
    	
    	myService.b("hib", "hib");
    	System.out.println("b-end---------------------");
    	return "hi-b";
    }
    @RequestMapping("/aop/c")
    @ResponseBody
    public String aopC() throws Exception
    {
    	System.out.println("c-begin-------------------");
    	
    	myService.c();
    	System.out.println("c-end---------------------");
    	return "hi-c";
    }
    
    @RequestMapping("/c")
    @ResponseBody
    public String c(String body, @RequestHeader("Accept") String header)
    {
    	System.out.println("/c");
    	System.out.println(body);
    	System.out.println(header);
    	//System.out.println(header);
    	return "/c";
    }
    
    @RequestMapping("/valid")
    public void valid(@Valid Greeting greeting, BindingResult result)
    {
    	System.out.println("valid-------------------");
    	if (result.hasErrors())
    		System.out.println("This is an invalid");
    	System.out.println(greeting.getId());
    	System.out.println(greeting.getContent());
    	System.out.println("valid-------------------");
    }
    
    @RequestMapping("/jsp")
    public String jsp(Model model)
    {
    	model.addAttribute("spring2", "../spring2.jsp");
    	return "../spring2.jsp";
    }
    
    @RequestMapping("/jsp2")
    public String jsp2(Model model)
    {
    	model.addAttribute("spring2", "/spring2.jsp");
    	return "/spring2.jsp";
    }
}