package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;
//import com.action.UserAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class User_state extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		
		
		 if(session.get("username")!=null){
            return "success";  
	     }  

		// TODO Auto-generated method stub
		System.out.println("没有session");
		return "false";
	}

}
