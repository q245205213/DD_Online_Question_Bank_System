package com.action;

import java.net.URLDecoder;
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

public class UploadRecord extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	private UploadRecordReturn urr = new UploadRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	

	private String uplType;
	public String getUplType(){
		return uplType;
	}
	public void setUplType(String uplType) {
		this.uplType = uplType;
	}
	
	public String uploadRecord() throws Exception{
		
		req.setCharacterEncoding("utf-8");
		System.out.println("getName的值是：测试");
		String uplType = URLDecoder.decode(getUplType(), "utf-8"); 
		String group1 = req.getParameter("group1"); 
		String group2 = req.getParameter("group2"); 
		String group3 = req.getParameter("group3"); 
		String uplID = req.getParameter("uplID"); 
		String uplTitle = req.getParameter("uplTitle"); 
		String uplStatus = req.getParameter("uplStatus"); 
		String num = req.getParameter("num");
		int j = Integer.parseInt(num);
		String ckeditor1 = "ckeditor1" + j;
		String ckeditor2 = "ckeditor2" + j;
		String ckeditor3 = "ckeditor3" + j;
		String uplContent = req.getParameter(ckeditor1); 
		String uplAnswer = req.getParameter(ckeditor2); 
		String uplAnalysis = req.getParameter(ckeditor3); 
		String sql1;
		String sql2 = " select groupID from `group` where group1 = '"+group1+"'and group2 = '"+group2+"' and group3 = '"+group3+"'";
		ResultSet rs2 = dao2.executeQuery(sql2);
		
		if (rs2.first()==true) {
			int groupID = Integer.parseInt(rs2.getString(1));
			String sql3 = "update upload set groupID = ("+groupID+") where uplID = " + uplID;		
			dao.executeUpdate(sql3);
		}
		else {
			String sql4 = "insert into `group`(group1,group2,group3) values('"+group1+"','"+group2+"','"+group3+"')";	
			dao.executeUpdate(sql4);
			rs2 = dao.executeQuery(sql2);
			rs2.first();
			int groupID = Integer.parseInt(rs2.getString(1));
			String sql5 = "update upload set groupID = ("+groupID+") where uplID = " + uplID;		
			dao.executeUpdate(sql5);
		}

		if (!uplType.equals("")) {
			sql1 = "update upload set uplType = ('"+uplType+"') where uplID = " + uplID;		
			dao.executeUpdate(sql1);
		}
		if (!uplStatus.equals("审核中")) {
			sql1 = "update upload set uplStatus = ('审核中') where uplID = " + uplID;		
			dao.executeUpdate(sql1);
		}
		if (!uplTitle.equals("")) {
			sql1 = "update upload set uplTitle = ('"+uplTitle+"') where uplID = " + uplID;		
			dao.executeUpdate(sql1);
		}
		if (!ckeditor1.equals("")) {
			sql1 = "update upload set uplContent = ('"+uplContent+"') where uplID = " + uplID;		
			dao.executeUpdate(sql1);
		}
		if (!ckeditor2.equals("")) {
			sql1 = "update upload set uplAnswer = ('"+uplAnswer+"') where uplID = " + uplID;				
			dao.executeUpdate(sql1);
		}
		if (!ckeditor3.equals("")) {
			sql1 = "update upload set uplAnalysis = ('"+uplAnalysis+"') where uplID = " + uplID;				
			dao.executeUpdate(sql1);
		}

		String sql8 = "insert into upload_admin select * from upload where uplID = '" + uplID +"'";		
		dao.executeUpdate(sql8);
		urr.uploadRecordReturn();
		return "success";
	}

}
