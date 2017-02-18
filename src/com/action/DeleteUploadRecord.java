package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import com.action.UploadRecordReturn;

public class DeleteUploadRecord extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private UploadRecordReturn urr = new UploadRecordReturn(); 
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	
	public String deleteUploadRecord() throws Exception {


		String uplID = req.getParameter("uplID"); 
		String sql = "delete from upload where uplID = " + uplID;
		dao.executeUpdate(sql);
		urr.uploadRecordReturn();
		return SUCCESS;
	}
}
