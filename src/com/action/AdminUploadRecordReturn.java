package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.Dao2;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;
//import com.action.UserAction;

public class AdminUploadRecordReturn extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String adminUploadRecordReturn() throws Exception{
		
		int i = 1;
		String sql1 = "select adminID from admin where adminAccount='"+session.get("username")+"'";
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		System.out.println("前进1");
		int adminID = Integer.parseInt(rs1.getString(1));
		
		String sql2 = "select * from question where adminID = '"+adminID+"' order by queID desc";
		System.out.println("adminID="+adminID);
		ResultSet rs2 = dao.executeQuery(sql2);
		
		List<String > adminUploadRecords = new ArrayList<String>(); 
		while (rs2.next()) {
			String groupID = rs2.getString(4);
			String sql3 = "select * from `group` where groupID='"+groupID+"'";
			ResultSet rs3 = dao2.executeQuery(sql3);
			rs3.first();
			String group1 = rs3.getString(2);
			String group2 = rs3.getString(3);
			String group3 = rs3.getString(4);
			session.put("group1", group1);
			session.put("group2", group2);
			session.put("group3", group3);
			String queType = "queType" + i;
			String queTitle = "queTitle" + i;
			String queContent = "queContent" + i;
			String queAnswer = "queAnswer" + i;
			String queAnalysis = "queAnalysis" + i;
			String ID = rs2.getString(1);
			String type = rs2.getString(5);
			String title = rs2.getString(6);
			String content = rs2.getString(7);
			String answer = rs2.getString(8);
			String analysis = rs2.getString(9);
			session.put(queType, rs2.getString(5));
			session.put(queTitle, rs2.getString(6));
			session.put(queContent, rs2.getString(7));
			session.put(queAnswer, rs2.getString(8));
			session.put(queAnalysis, rs2.getString(9));
			String ckeditor1 = "ckeditor1" + i;
			String ckeditor2 = "ckeditor2" + i;
			String ckeditor3 = "ckeditor3" + i;
			String modifyButton = "modifyButton" + i;
			String deleteButton = "deleteButton" + i;
			String submitButton = "submitButton" + i;
			String backButton = "backButton" + i;
			String questionUpload = "questionUpload" + i;
			
			String adminUploadRecord = 
				"<form action=\"deleteAdminUploadRecord\" method=\"post\">"+
					"<div class=\"div-1\">"+
						"题目类型：<label>"+type+"</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"题目分组："+group1+">"+group2+">"+group3+"<br /><br />"+
						"题目题号：<label>"+ID+"</label>"+ 
						"<input type=\"hidden\" name=\"queID\" value=\""+ID+"\"/>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"题目标题："+title+"</label><br /><br /> "+
						"<input class=\"button recordShow\" type=\"button\" id=\""+modifyButton+"\"	value=\"修改\" /> "+
						"<input class=\"button\" type=\"submit\" id=\""+deleteButton+"\" value=\"删除\" />"+
					"</div>"+
				"</form>"+	
				"<div id=\""+questionUpload+"\" class=\"question-upload\">"+
					"<form class=\"form-upload\" action=\"adminUploadRecord\" method=\"post\">"+
						"<div>"+
							"<input type=\"hidden\" name=\"queID\" value=\""+ID+"\"/>"+
							"<input type=\"hidden\" name=\"num\" value=\""+i+"\"/>"+
							"<p>题目类型：</p>"+
							"<select name=\"queType\">"+
								"<option>"+type+"</option>"+
								"<option>选择题</option>"+
								"<option>填空题</option>"+
								"<option>判断题</option>"+
								"<option>解答题</option>"+
							"</select>"+
						"</div>"+
						"<div class=\"question-group\">"+
							"<p>题目分组：</p>"+
							"<div>"+
								"<select class=\"group1\" id=\"group1"+i+"\" name=\"group1\">"+
									"<option>"+group1+"</option>"+
								"</select> "+
								"<select class=\"group2\" id=\"group2"+i+"\" name=\"group2\">"+
									"<option>"+group2+"</option>"+
								"</select> "+
								"<select class=\"group3\" id=\"group3"+i+"\" name=\"group3\">"+
									"<option>"+group3+"</option>"+
								"</select>"+
							"</div>"+
						"</div>"+
						"<div class=\"quetion-title\">"+
							"<p>题目标题：</p>"+
							"<input type=\"text\" name=\"queTitle\" class=\"text-queTitle\" value=\""+title+"\" />"+
						"</div>"+
						"<div>"+
							"<p>题目问题：</p>"+ 
							"<div class=\"textarea1\">"+
								"<textarea  name=\""+ckeditor1+"\" rows=\"\" >"+content+"</textarea>"+
							"</div>"+
						"</div>"+
						"<div>"+
						"<p>题目答案：</p>"+
							"<div class=\"textarea2\">"+
								"<textarea  name=\""+ckeditor2+"\" rows=\"\" >"+answer+"</textarea>"+
							"</div>"+
						"</div>"+
						"<div>"+
							"<p>题目解析：</p>"+
							"<div class=\"textarea3\">"+
								"<textarea  name=\""+ckeditor3+"\" rows=\"\" >"+analysis+"</textarea>"+
							"</div>"+
						"</div>"+
						"<input type=\"submit\" name=\"\" id=\""+submitButton+"\" class=\"submit-upload button\" value=\"重新上传\" />"+
					"</form>"+
					"<input type=\"button\" name=\"\" id=\""+backButton+"\" class=\"button recordHide\" value=\"收起\" />"+
				"</div>";
			

			adminUploadRecords.add(adminUploadRecord);
			session.put("adminUploadRecords", adminUploadRecords);
			session.put("i", i);
			++i;
			
		}
		if (!rs2.first()) {
			String adminUploadRecord = "";
			adminUploadRecords.add(adminUploadRecord);
			session.put("adminUploadRecords",adminUploadRecords);
//			session.put("i", "");
			dao.allClose(dao);
			dao2.allClose(dao2);
			return SUCCESS;
		}
		dao.allClose(dao);
		dao2.allClose(dao2);
		return SUCCESS;
	}
}
