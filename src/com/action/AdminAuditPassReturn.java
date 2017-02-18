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

public class AdminAuditPassReturn extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String adminAuditPassReturn() throws Exception{
		
		int i = 1;
		String sql1 = "select * from question where isnull(adminID) order by queID desc";
		ResultSet rs1 = dao.executeQuery(sql1);
		
		List<String > adminAuditPasses = new ArrayList<String>(); 
		while (rs1.next()) {
			String groupID = rs1.getString(4);
			String sql3 = "select * from `group` where groupID='"+groupID+"'";
			ResultSet rs3 = dao2.executeQuery(sql3);
			rs3.first();
			String group1 = rs3.getString(2);
			String group2 = rs3.getString(3);
			String group3 = rs3.getString(4);
			String queID = rs1.getString(1);
			String queType = rs1.getString(5);
			String queTitle = rs1.getString(6);
			String queContent = rs1.getString(7);
			String queAnswer = rs1.getString(8);
			String queAnalysis = rs1.getString(9);
			String ckeditor1 = "ckeditor1" + i;
			String ckeditor2 = "ckeditor2" + i;
			String ckeditor3 = "ckeditor3" + i;
			String modifyButton = "modifyButton" + i;
			String deleteButton = "deleteButton" + i;
			String submitButton = "submitButton" + i;
			String backButton = "backButton" + i;
			String questionUpload = "questionUpload" + i;
			
			String adminAuditPass = 
				"<form action=\"deleteAdminAuditPass\" method=\"post\">"+
					"<div class=\"div-1\">"+
						"题目类型：<label>"+queType+"</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"题目分组："+group1+">"+group2+">"+group3+"<br /><br />"+
						"题目题号：<label>"+queID+"</label>"+ 
						"<input type=\"hidden\" name=\"queID\" value=\""+queID+"\"/>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"题目标题："+queTitle+"</label><br /><br /> "+
						"<input class=\"button recordShow\" type=\"button\" id=\""+modifyButton+"\"	value=\"展开\" /> "+
						"<input class=\"button\" type=\"submit\" id=\""+deleteButton+"\" value=\"删除\" />"+
					"</div>"+
				"</form>"+	
				"<div id=\""+questionUpload+"\" class=\"question-upload\">"+
					"<form class=\"form-upload\" action=\"adminAuditPass\" method=\"post\">"+
						"<div>"+
							"<input type=\"hidden\" name=\"queID\" value=\""+queID+"\"/>"+
							"<input type=\"hidden\" name=\"num\" value=\""+i+"\"/>"+
							"<p>题目类型：</p>"+
							"<select name=\"queType\">"+
								"<option>"+queType+"</option>"+
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
							"<input type=\"text\" name=\"queTitle\" class=\"text-queTitle\" value=\""+queTitle+"\" />"+
						"</div>"+
						"<div>"+
							"<p>题目问题：</p>"+ 
							"<div class=\"textarea1\">"+
								"<textarea  name=\""+ckeditor1+"\" rows=\"\" >"+queContent+"</textarea>"+
							"</div>"+
						"</div>"+
						"<div>"+
						"<p>题目答案：</p>"+
							"<div class=\"textarea2\">"+
								"<textarea  name=\""+ckeditor2+"\" rows=\"\" >"+queAnswer+"</textarea>"+
							"</div>"+
						"</div>"+
						"<div>"+
							"<p>题目解析：</p>"+
							"<div class=\"textarea3\">"+
								"<textarea  name=\""+ckeditor3+"\" rows=\"\" >"+queAnalysis+"</textarea>"+
							"</div>"+
						"</div>"+
						"<input type=\"submit\" name=\"\" id=\""+submitButton+"\" class=\"submit-upload button\" value=\"修改\" />"+
					"</form>"+
					"<input type=\"button\" name=\"\" id=\""+backButton+"\" class=\"button recordHide\" value=\"收起\" />"+
				"</div>";
			

			adminAuditPasses.add(adminAuditPass);
			session.put("adminAuditPasses", adminAuditPasses);
			session.put("i", i);
			++i;
			
		}
		if (!rs1.first()) {
			String adminAuditPass = "";
			adminAuditPasses.add(adminAuditPass);
			session.put("adminAuditPasses",adminAuditPasses);
//			session.put("i", "");
			return SUCCESS;
		}
		return SUCCESS;
	}
}
