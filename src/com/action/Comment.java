package com.action;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;
import com.action.CommentRecordReturn;

public class Comment extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private CommentRecordReturn crr = new CommentRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String comment() throws Exception{
		
		String queID = req.getParameter("queID");
		String comContent = req.getParameter("comContent");
		String comScore = req.getParameter("comScore");
		String userAccount = (String) session.get("username");
		System.out.println("queID的值是："+queID);
		System.out.println("comContent的值是："+comContent);
		System.out.println("comScore的值是："+comScore);
		System.out.println("userAccount的值是："+userAccount);
		String sql1 = "select userID from user where userAccount ='"+userAccount+"'";
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		int userID = Integer.parseInt(rs1.getString(1));			
		String sql2 = "insert into comment(userID,queID,comContent,comScore) values('"+userID+"','"+queID+"','"+comContent+"','"+comScore+"')";
		dao.executeUpdate(sql2);
		System.out.println("评论成功");
		crr.commentRecordReturn();
		dao.allClose(dao);
		return SUCCESS;
	}
}
