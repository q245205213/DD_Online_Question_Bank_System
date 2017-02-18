package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	public String hello(){
		return SUCCESS;
	}
}
