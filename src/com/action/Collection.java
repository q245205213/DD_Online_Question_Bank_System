package com.action;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;

public class Collection extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public void collection() throws Exception{
		
		String queID = req.getParameter("queID");
		String userAccount = (String) session.get("username");
		String sql1 = "select userID from user where userAccount ='"+userAccount+"'";
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		int userID = Integer.parseInt(rs1.getString(1));			
		String sql2 = "insert into collection(userID,queID) values('"+userID+"','"+queID+"')";
		dao.executeUpdate(sql2);
		System.out.println("收藏成功");
		dao.allClose(dao);
		return;
	}
}
