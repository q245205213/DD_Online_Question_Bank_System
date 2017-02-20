package com.action;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.Dao2;
import com.action.AdminUploadRecordReturn;

public class AdminUploadRecord extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	private AdminUploadRecordReturn aurr = new AdminUploadRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String adminUploadRecord() throws Exception{
		
		req.setCharacterEncoding("utf-8");
		System.out.println("getName的值是：测试");
		String queType = req.getParameter("queType"); 
		String group1 = req.getParameter("group1"); 
		String group2 = req.getParameter("group2"); 
		String group3 = req.getParameter("group3"); 
		String queID = req.getParameter("queID"); 
		String queTitle = req.getParameter("queTitle"); 
		String num = req.getParameter("num");
		int j = Integer.parseInt(num);
		String ckeditor1 = "ckeditor1" + j;
		String ckeditor2 = "ckeditor2" + j;
		String ckeditor3 = "ckeditor3" + j;
		String queContent = req.getParameter(ckeditor1); 
		String queAnswer = req.getParameter(ckeditor2); 
		String queAnalysis = req.getParameter(ckeditor3); 
		String sql1;
		String sql2 = " select groupID from `group` where group1 = '"+group1+"'and group2 = '"+group2+"' and group3 = '"+group3+"'";
		ResultSet rs2 = dao2.executeQuery(sql2);
		
		if (rs2.first()==true) {
			int groupID = Integer.parseInt(rs2.getString(1));
			String sql3 = "update question set groupID = ("+groupID+") where queID = " + queID;		
			dao.executeUpdate(sql3);
		}
		else {
			String sql4 = "insert into `group`(group1,group2,group3) values('"+group1+"','"+group2+"','"+group3+"')";	
			dao.executeUpdate(sql4);
			rs2 = dao.executeQuery(sql2);
			rs2.first();
			int groupID = Integer.parseInt(rs2.getString(1));
			String sql5 = "update question set groupID = ("+groupID+") where queID = " + queID;		
			dao.executeUpdate(sql5);
		}

		if (!queType.equals("")) {
			sql1 = "update question set queType = ('"+queType+"') where queID = " + queID;		
			dao.executeUpdate(sql1);
		}
		if (!queTitle.equals("")) {
			sql1 = "update question set queTitle = ('"+queTitle+"') where queID = " + queID;		
			dao.executeUpdate(sql1);
		}
		if (!ckeditor1.equals("")) {
			sql1 = "update question set queContent = ('"+queContent+"') where queID = " + queID;		
			dao.executeUpdate(sql1);
		}
		if (!ckeditor2.equals("")) {
			sql1 = "update question set queAnswer = ('"+queAnswer+"') where queID = " + queID;				
			dao.executeUpdate(sql1);
		}
		if (!ckeditor3.equals("")) {
			sql1 = "update question set queAnalysis = ('"+queAnalysis+"') where queID = " + queID;				
			dao.executeUpdate(sql1);
		}
		aurr.adminUploadRecordReturn();
		dao.allClose(dao);
		dao2.allClose(dao2);
		return "success";
	}

}
