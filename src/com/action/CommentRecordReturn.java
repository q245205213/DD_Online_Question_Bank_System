package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;
import dao.Dao2;

public class CommentRecordReturn extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String commentRecordReturn() throws Exception{
		
		String userAccount = (String) session.get("username");
		System.out.println("userAccount的值是："+userAccount);
		String sql1 = "select userID from user where userAccount = '"+userAccount+"'";
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		String userID = rs1.getString(1);
		String sql2 = "select * from comment where userID = "+userID+" order by comID desc" ;
		ResultSet rs2 = dao.executeQuery(sql2);
		List<String > commentRecords = new ArrayList<String>(); 
		
		while (rs2.next()) {
			String queID = rs2.getString(3);
			String comContent = rs2.getString(4);
			String comScore = rs2.getString(5);
			String sql3 = "select queTitle from question where queID = '"+queID+"'";
			ResultSet rs3 = dao2.executeQuery(sql3);
			rs3.first();			
			String queTitle = rs3.getString(1);
			String commentRecord = 
			"	<div>"+
			"		题目标题： <a href=\"lookupQuestion?queID="+queID+"\">"+queTitle+"</a><br />"+
			"		<br /> 评论内容：<label>"+comContent+"</label><br />"+
			"		<br /> 评分：<label>"+comScore+"</label>"+
			"	</div>";		
			commentRecords.add(commentRecord);
			session.put("commentRecords", commentRecords);
			
			
			
		}
		return SUCCESS;
	}
}
