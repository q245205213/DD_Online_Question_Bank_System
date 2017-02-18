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

public class CollectionRecordReturn extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String collectionRecordReturn() throws Exception{
		
		String userAccount = (String) session.get("username");
		String sql1 = "select userID from user where userAccount = '"+userAccount+"'";
		System.out.println("username:"+userAccount);
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		String userID = rs1.getString(1);
		String sql2 = "select queID,colID from collection where userID = "+userID+"";
		ResultSet rs2 = dao.executeQuery(sql2);
		List<String > collectionRecords = new ArrayList<String>(); 
		
		while (rs2.next()) {
			String queID = rs2.getString(1);
			String colID = rs2.getString(2);
			String sql3 = "select queType,queTitle from question where queID = '"+queID+"'";
			ResultSet rs3 = dao2.executeQuery(sql3);
			rs3.first();			
			String queType = rs3.getString(1);
			String queTitle = rs3.getString(2);
			
			String collectionRecord = 
			"	<tr>"+
			"		<td>"+queID+"</td>"+
			"		<td>"+queType+"</td>"+
			"		<td>"+queTitle+"</td>"+
			"		<td><a href=\"lookupQuestion?queID="+queID+"\">查看</a>&nbsp;&nbsp;<a href=\"deleteCollectionRecord?colID="+colID+"\">删除</a></td>"+
			"	</tr>";
			

			collectionRecords.add(collectionRecord);
			session.put("collectionRecords", collectionRecords);
							
		}
		if (!rs2.first()) {
			String collectionRecord = "";
			collectionRecords.add(collectionRecord);
			session.put("collectionRecords",collectionRecords);
			return SUCCESS;
		}
		return SUCCESS;
	}
}
