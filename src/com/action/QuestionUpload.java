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

import com.action.UploadRecordReturn;

public class QuestionUpload extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	private UploadRecordReturn urr = new UploadRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();

	public String questionUpload() throws Exception{

		System.out.println("getName的值是：测试");
		String select = req.getParameter("select"); 
		String group1 = req.getParameter("group1"); 
		String group2 = req.getParameter("group2"); 
		String group3 = req.getParameter("group3"); 
		System.out.println("group1的值是："+group1);
		System.out.println("group2的值是："+group2);
		System.out.println("group3的值是："+group3);
		String uplTitle = req.getParameter("uplTitle"); 
		String uplContent = req.getParameter("uplContent"); ; 
		String uplAnswer = req.getParameter("uplAnswer"); ; 
		String uplAnalysis = req.getParameter("uplAnalysis"); 
		System.out.println("我是有用的:"+uplContent);

		String sql7 = "select userID from user where userAccount='"+session.get("username")+"'";
		ResultSet rs4 = dao.executeQuery(sql7);
		System.out.println("rs4的值是："+rs4);
		rs4.first();
		String sql = "insert into upload(userID,uplType,uplStatus) values('"+rs4.getString(1)+"','"+select+"','审核中')";		
		dao.executeUpdate(sql);
		String sql2 = " select * from upload order by uplID desc limit 1";
		String sql3 = " select groupID from `group` where group1 = '"+group1+"'and group2 = '"+group2+"' and group3 = '"+group3+"'";
		String sql4 = "insert into `group`(group1,group2,group3) values('"+group1+"','"+group2+"','"+group3+"')";	
		ResultSet rs1 = dao2.executeQuery(sql2);
		rs1.first();
		ResultSet rs2 = dao.executeQuery(sql3);
		String uplID = rs1.getString(1);
//		rs2.next();
//		System.out.println("rs2的值是："+rs2.getString(1));
		
		if (rs2.next()==true) {
			int groupID = Integer.parseInt(rs2.getString(1));
			String sql6 = "update upload set groupID = ("+groupID+") where uplID = " + uplID;		
			dao.executeUpdate(sql6);
		}
		else {
			dao.executeUpdate(sql4);
			ResultSet rs3 = dao.executeQuery(sql3);
			rs3.first();
			int groupID = Integer.parseInt(rs3.getString(1));
			String sql5 = "update upload set groupID = ("+groupID+") where uplID = " + uplID;		
			dao.executeUpdate(sql5);
		}
		
		if (!uplTitle.equals("")) {
			sql = "update upload set uplTitle = ('"+uplTitle+"') where uplID = '" + uplID +"'";		
			dao.executeUpdate(sql);
		}
		if (!uplContent.equals("")) {
		sql = "update upload set uplContent = ('"+uplContent+"') where uplID = '" + uplID +"'";		
		dao.executeUpdate(sql);
		}
		if (!uplAnswer.equals("")) {
			sql = "update upload set uplAnswer = ('"+uplAnswer+"') where uplID = '" + uplID +"'";		
			dao.executeUpdate(sql);
		}
		if (!uplAnalysis.equals("")) {
			sql = "update upload set uplAnalysis = ('"+uplAnalysis+"') where uplID = '" + uplID +"'";		
			dao.executeUpdate(sql);
		}
		String sql8 = "insert into upload_admin select * from upload where uplID = '" + uplID +"'";		
		dao.executeUpdate(sql8);
		urr.uploadRecordReturn();
		return "success";
	}
}
