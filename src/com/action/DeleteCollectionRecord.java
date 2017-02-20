package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;
import com.action.CollectionRecordReturn;

public class DeleteCollectionRecord extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private CollectionRecordReturn crr = new CollectionRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String deleteCollectionRecord() throws Exception{
		
		String colID = req.getParameter("colID");
		System.out.println("colID的值是："+colID);
		String sql = "delete from collection where colID = " + colID;
		dao.executeUpdate(sql);
		crr.collectionRecordReturn();
		dao.allClose(dao);
		return SUCCESS;
	}
}
