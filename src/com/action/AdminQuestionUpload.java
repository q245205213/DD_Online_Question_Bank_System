package com.action;

import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import com.action.AdminUploadRecordReturn;

public class AdminQuestionUpload extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private AdminUploadRecordReturn aurr = new AdminUploadRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();

	public String adminQuestionUpload() throws Exception{

		System.out.println("getName的值是：测试");
		String select = req.getParameter("select"); 
		String group1 = req.getParameter("group1"); 
		String group2 = req.getParameter("group2"); 
		String group3 = req.getParameter("group3"); 
		String queTitle = req.getParameter("queTitle"); 
		String queContent = req.getParameter("queContent"); ; 
		String queAnswer = req.getParameter("queAnswer"); ; 
		String queAnalysis = req.getParameter("queAnalysis"); 

		String sql7 = "select adminID from admin where adminAccount='"+session.get("username")+"'";
		ResultSet rs4 = dao.executeQuery(sql7);
		rs4.first();
		String sql = "insert into question(adminID,queType) values('"+rs4.getString(1)+"','"+select+"')";		
		dao.executeUpdate(sql);
		String sql2 = " select * from question order by queID desc limit 1";
		String sql3 = " select groupID from `group` where group1 = '"+group1+"'and group2 = '"+group2+"' and group3 = '"+group3+"'";
		String sql4 = "insert into `group`(group1,group2,group3) values('"+group1+"','"+group2+"','"+group3+"')";	
		ResultSet rs2 = dao.executeQuery(sql3);
		
		if (rs2.next()==true) {
			int groupID = Integer.parseInt(rs2.getString(1));
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql6 = "update question set groupID = ("+groupID+") where queID = " +rs.getString(1);		
			dao.executeUpdate(sql6);
		} 
		else {
			dao.executeUpdate(sql4);
			ResultSet rs3 = dao.executeQuery(sql3);
			rs3.first();
			int groupID = Integer.parseInt(rs3.getString(1));
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql5 = "update question set groupID = ("+groupID+") where queID = " +rs.getString(1);		
			dao.executeUpdate(sql5);
		}
		
		if (!queTitle.equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			sql = "update question set queTitle = ('"+queTitle+"') where queID = '" +rs.getString(1)+"'";		
			dao.executeUpdate(sql);
		}
		if (!queContent.equals("")) {
		ResultSet rs = dao.executeQuery(sql2);
		rs.next();
		sql = "update question set queContent = ('"+queContent+"') where queID = '" +rs.getString(1)+"'";		
		dao.executeUpdate(sql);
		}
		if (!queAnswer.equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			sql = "update question set queAnswer = ('"+queAnswer+"') where queID = '" +rs.getString(1)+"'";		
			dao.executeUpdate(sql);
		}
		if (!queAnalysis.equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			sql = "update question set queAnalysis = ('"+queAnalysis+"') where queID = '" +rs.getString(1)+"'";		
			dao.executeUpdate(sql);
		}
		
		aurr.adminUploadRecordReturn();
		return "success";
	}
}
