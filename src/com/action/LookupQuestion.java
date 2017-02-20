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
import dao.Dao3;

public class LookupQuestion extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	private Dao3 dao3 = new Dao3();
	private LookupQuestion lq = new LookupQuestion();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	
	public void close() {
		dao.allClose(dao);
		dao2.allClose(dao2);
		dao3.allClose(dao3);
	}
	
	public String lookupQuestion() throws Exception {

		List<String> lookupQuestions = new ArrayList<String>(); 
		String queID = req.getParameter("queID");
		String sql1 = "select * from question where queID = " + queID;
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		int i = 1;
		String groupID = rs1.getString(4);
		String queType = rs1.getString(5);
		String queTitle = rs1.getString(6);
		String queContent = rs1.getString(7);
		String queAnswer = rs1.getString(8);
		String queAnalysis = rs1.getString(9);
		String collection = "collection" + i;
		String queID2 = "queID" + i;

		String sql2 = "select comScore from comment where queID = '"+queID+"'";
		ResultSet rs2 = dao2.executeQuery(sql2);
		String sql6 = "select group1,group2,group3 from `group` where groupID = " + groupID;
		ResultSet rs6 = dao3.executeQuery(sql6);
		rs6.first();
		String group1 = rs6.getString(1);
		String group2 = rs6.getString(2);
		String group3 = rs6.getString(3);
		req.setAttribute("group1", group1);
		req.setAttribute("group2", group2);
		req.setAttribute("group3", group3);
		float comScore = 0;
		int k = 0;
		while (rs2.next()) {
			comScore += rs2.getFloat(1);
			k++;
		}
		float aveScores;
		String aveScore;
		if (k != 0) {
			aveScores = comScore / k;
			aveScore = String.format("%.1f",aveScores);
			
		}
		else {
			aveScore = "3.0";
		}
		System.out.println("aveScore的值是："+aveScore);
		if (rs1.getString(2) == null) {
			String userID = rs1.getString(3);
			String sql3 = "select userAccount from user where userID = '"+userID+"'";
			ResultSet rs3 = dao2.executeQuery(sql3);
			rs3.first();
			String userAccount = rs3.getString(1);		
			String sql4 = "select userID,comContent from comment where queID = '"+queID+"'";
			System.out.println("queID的2值是："+queID);
			ResultSet rs4 = dao2.executeQuery(sql4);
			StringBuilder userComments = new StringBuilder();
			String userComment = null;
			while (rs4.next()) {
				userID = rs4.getString(1);
				String comContent = rs4.getString(2);
				String sql5= "select userAccount from user where userID ='"+userID+"'";
				System.out.println("userID的2值是："+userID);
				ResultSet rs5 = dao3.executeQuery(sql5); 
				rs5.first();
				userAccount = rs5.getString(1);	
				userComments.append("<p>用户"+userAccount+":&nbsp;"+comContent+"</p>");
				userComment = userComments.toString();
				System.out.println("userComment的值是："+userComment);
			}			
		
			String lookupQuestion = 
			"		<div id=\"\">"+
			"		<div id=\"\">"+
			"			<b>题目："+queTitle+"</b><br /><br />"+
			"			<b>题型：</b>"+queType+"<br /><br />"+
			"			<div><b>题目内容：</b>"+queContent+
			"			</div>"+
			"			<div class=\"blockBottom\">"+
			"				<ul>"+
			"					<li><a href=\"javascript:void(0);\" id=\"a-answer"+i+"\">答案解析</a></li>"+
			"					<li><a href=\"#\" id=\""+collection+"\">我要收藏</a></li>"+
			"					<li>题号：<span id=\""+queID2+"\">"+queID+"</span></li>"+
			"					<li>作者："+userAccount+"</li>"+
			"					<li>分数："+aveScore+"<img src=\"img/starLight.png\" width=\"18\" height=\"18\" /></li>"+
			"					<li><a href=\"javascript:void(0);\" id=\"comment"+i+"\">评论</a></li>"+
			"				</ul>"+
			"			</div>"+
			"		</div>"+
			"		<div class=\"answer-analysis\" id=\"answer-analysis"+i+"\">"+
			"			<p>"+
			"				<b>答案：</b>"+queAnswer+
			"			</p>"+
			"			<p>"+
			"				<b>解析：</b>"+queAnalysis+
			"			</p>"+
			"		</div>"+
			"		<div class=\"div-comment comment\" id=\"commentContent"+i+"\">"+
			"			<div>"+
			"				<form id=\"formComment"+i+" class=\"commentReply\" action=\"comment\" method=\"post\">"+
			"					<p class=\"score2\"><b>评分：</b></p>"+
			"					<ul class=\"star\">"+
			"						<li><img src=\"img/starLight.png\" width=\"20\" height=\"20\" /></li>"+
			"						<li><img src=\"img/starLight.png\" width=\"20\" height=\"20\" /></li>"+
			"						<li><img src=\"img/starLight.png\" width=\"20\" height=\"20\" /></li>"+
			"						<li><img src=\"img/starDark.png\" width=\"20\" height=\"20\" /></li>"+
			"						<li><img src=\"img/starDark.png\" width=\"20\" height=\"20\" /></li>"+
			"					</ul>"+
			"					<span class=\"score\"><input type=\"hidden\" id=\"\" name=\"comScore\" value=\"3\"/>3分</span>"+
			"					<br />"+
			"					<p class=\"comment0\">"+
			"						<b>评论内容：</b>"+
			"					</p>"+
			"					<textarea name=\"comContent\" id=\"comContent"+i+"\" rows=\"2\" cols=\"80\"></textarea>"+
			"					<div id=\"\">"+
			"						<input type=\"hidden\" name=\"queID\" value=\""+queID+"\" />"+
			"						<input type=\"submit\" id=\"commentSubmit"+i+"\" value=\"提交\" />"+
			"					</div>"+
			"				</form>"+
			"			</div>"+
			"			<div>"+
			"				<p>"+
			"					<b>大家看法：</b>"+
			"				</p>"+userComment+
			"			</div>"+
			"		</div>"+
			"	</div>";
			lookupQuestions.add(lookupQuestion);		
		}
		else {
			String admin = "admin";		
			String sql4 = "select userID,comContent from comment where queID = '"+queID+"'";
			System.out.println("queID的2值是："+queID);
			ResultSet rs4 = dao2.executeQuery(sql4);
			StringBuilder userComments = new StringBuilder();
			String userComment = null;
			while (rs4.next()) {
				String userID = rs4.getString(1);
				String comContent = rs4.getString(2);
				String sql5= "select userAccount from user where userID ='"+userID+"'";
				System.out.println("userID的2值是："+userID);
				ResultSet rs5 = dao3.executeQuery(sql5); 
				rs5.first();
				String userAccount = rs5.getString(1);	
				userComments.append("<p>用户"+userAccount+":&nbsp;"+comContent+"</p>");
				userComment = userComments.toString();
				System.out.println("userComment的值是："+userComment);
			}
			String lookupQuestion = 
					"		<div id=\"\">"+
					"		<div id=\"\">"+
					"			<b>题目："+queTitle+"</b><br /><br />"+
					"			<b>题型：</b>"+queType+"<br /><br />"+
					"			<div><b>题目内容：</b>"+queContent+
					"			</div>"+
					"			<div class=\"blockBottom\">"+
					"				<ul>"+
					"					<li><a href=\"javascript:void(0);\" id=\"a-answer"+i+"\">答案解析</a></li>"+
					"					<li><a href=\"#\" id=\""+collection+"\">我要收藏</a></li>"+
					"					<li>题号：<span id=\""+queID2+"\">"+queID+"</span></li>"+
					"					<li>作者："+admin+"</li>"+
					"					<li>分数："+aveScore+"<img src=\"img/starLight.png\" width=\"18\" height=\"18\" /></li>"+
					"					<li><a href=\"javascript:void(0);\" id=\"comment"+i+"\">评论</a></li>"+
					"				</ul>"+
					"			</div>"+
					"		</div>"+
					"		<div class=\"answer-analysis\" id=\"answer-analysis"+i+"\">"+
					"			<p>"+
					"				<b>答案：</b>"+queAnswer+
					"			</p>"+
					"			<p>"+
					"				<b>解析：</b>"+queAnalysis+
					"			</p>"+
					"		</div>"+
					"		<div class=\"div-comment comment\" id=\"commentContent"+i+"\">"+
					"			<div>"+
					"				<form id=\"formComment"+i+" class=\"commentReply\" action=\"comment\" method=\"post\">"+
					"					<p class=\"score2\"><b>评分：</b></p>"+
					"					<ul class=\"star\">"+
					"						<li><img src=\"img/starLight.png\" width=\"20\" height=\"20\" /></li>"+
					"						<li><img src=\"img/starLight.png\" width=\"20\" height=\"20\" /></li>"+
					"						<li><img src=\"img/starLight.png\" width=\"20\" height=\"20\" /></li>"+
					"						<li><img src=\"img/starDark.png\" width=\"20\" height=\"20\" /></li>"+
					"						<li><img src=\"img/starDark.png\" width=\"20\" height=\"20\" /></li>"+
					"					</ul>"+
					"					<span class=\"score\"><input type=\"hidden\" id=\"\" name=\"comScore\" value=\"3\"/>3分</span>"+
					"					<br />"+
					"					<p class=\"comment0\">"+
					"						<b>评论内容：</b>"+
					"					</p>"+
					"					<textarea name=\"comContent\" id=\"comContent"+i+"\" rows=\"2\" cols=\"80\"></textarea>"+
					"					<div id=\"\">"+
					"						<input type=\"hidden\" name=\"queID\" value=\""+queID+"\" />"+
					"						<input type=\"submit\" id=\"commentSubmit"+i+"\" value=\"提交\" />"+
					"					</div>"+
					"				</form>"+
					"			</div>"+
					"			<div>"+
					"				<p>"+
					"					<b>大家看法：</b>"+
					"				</p>"+userComment+
					"			</div>"+
					"		</div>"+
					"	</div>";
			lookupQuestions.add(lookupQuestion);						
		}
		req.setAttribute("i", i);
		switch (group1) {
		case "小学":
			req.setAttribute("primarySchools", lookupQuestions);
			lq.close();
			return "primarySchool";
		case "中学":
			req.setAttribute("middleSchools", lookupQuestions);
			lq.close();
			return "middleSchool";
		case "大学":
			switch (group2) {
			case "大学必修课":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university";
			case "信息科学与工程学院":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university2";
			case "经济管理学院":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university3";
			case "生命科学学院":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university4";
			case "工程学院 ":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university5";
			case "人文与法学学院":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university6";
			case "艺术学院":
				req.setAttribute("universitys", lookupQuestions);
				lq.close();
				return "university7";

			default:
				break;
			}
		case "社会职业":
			req.setAttribute("socialProfessions", lookupQuestions);
			lq.close();
			return "socialProfession";

		default:
			break;
		}
		lq.close();
		return SUCCESS;
	}

}
