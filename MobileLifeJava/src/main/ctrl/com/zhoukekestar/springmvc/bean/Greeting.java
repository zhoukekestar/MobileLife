package com.zhoukekestar.springmvc.bean;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component("greeting")
public class Greeting {

    private long id;
    
    @NotNull(message="不能为null")
    private String content;

    public Greeting()
    {
    	/*this.id = 1333;
    	this.content = "default by zkk";*/
    }
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}