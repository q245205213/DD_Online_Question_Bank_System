package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import com.action.AdminUploadRecordReturn;

public class DeleteAdminUploadRecord extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private AdminUploadRecordReturn aurr = new AdminUploadRecordReturn(); 
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	
	public String deleteAdminUploadRecord() throws Exception {

		String queID = req.getParameter("queID"); 
		System.out.println("queID的值是："+queID);
		String sql = "delete from question where queID = " + queID;
		dao.executeUpdate(sql);
		aurr.adminUploadRecordReturn();
		dao.allClose(dao);
		return SUCCESS;
	}
}
