package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;
//import com.action.UserAction;

public class UserLoginState extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		
		
		 if(invocation.getAction().getClass()==UserAction.class||session.get("username")!=null)  
	        {
	            return invocation.invoke();  
	        }  

		// TODO Auto-generated method stub
		return "false";
	}

}
