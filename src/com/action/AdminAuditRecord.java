 package com.action;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.Dao2;
import com.action.AdminAuditRecordReturn;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;
//import com.action.UserAction;

public class AdminAuditRecord extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	private AdminAuditRecordReturn	aarr = new AdminAuditRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String passAudit() throws Exception{
		
		String uplID = req.getParameter("uplID"); 
		System.out.println("uplID的值是："+uplID);
		String sql2 = " select * from upload where uplID = "+uplID;
		ResultSet rs2 = dao2.executeQuery(sql2);
		if (rs2.first()==true) {
			String userID = rs2.getString(2);
			String groupID = rs2.getString(3);
			String uplType = rs2.getString(5);
			String uplTitle = rs2.getString(6);
			String uplContent = rs2.getString(7);
			String uplAnswer = rs2.getString(8);
			String uplAnalysis = rs2.getString(9);
			String sql3 = "insert into question(userID,groupID,queType,queTitle,queContent,queAnswer,queAnalysis) values('"+userID+"','"+groupID+"','"+uplType+"','"+uplTitle+"','"+uplContent+"','"+uplAnswer+"','"+uplAnalysis+"')";	
			dao.executeUpdate(sql3);
			String sql4 = "update upload set uplStatus = ('通过审核') where uplID = " + uplID;	
			dao.executeUpdate(sql4);
			String sql5 = "delete from upload_admin where uplID = " + uplID;
			dao.executeUpdate(sql5);
		}
		aarr.adminAuditRecordReturn();
		dao.allClose(dao);
		dao2.allClose(dao2);
		return SUCCESS;
	}

	public String noPassAudit() throws Exception{
		String uplID = req.getParameter("uplID"); 
		System.out.println("uplID的值是："+uplID);
		String sql2 = " select * from upload where uplID = '"+uplID+"'";
		ResultSet rs2 = dao2.executeQuery(sql2);
		if (rs2.first()==true) {
			String sql4 = "update upload set uplStatus = ('不通过') where uplID = " + uplID;	
			dao.executeUpdate(sql4);
			String sql5 = "delete from upload_admin where uplID = " + uplID;
			dao.executeUpdate(sql5);
		}
		aarr.adminAuditRecordReturn();
		dao.allClose(dao);
		dao2.allClose(dao2);
		return SUCCESS;
	}
}
