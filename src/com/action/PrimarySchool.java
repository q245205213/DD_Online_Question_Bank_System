package com.action;

import java.net.URLDecoder;
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

public class PrimarySchool extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Dao2 dao2 = new Dao2();
	private Dao3 dao3 = new Dao3();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	
	@SuppressWarnings("resource")
	public String primarySchool() throws Exception{
		int i = 1;
		String group1 = req.getParameter("group1");
		String group2 = req.getParameter("group2");
		String group3 = req.getParameter("group3");
		group1 = URLDecoder.decode(group1, "UTF-8"); 
		group2 = URLDecoder.decode(group2, "UTF-8"); 
		group3 = URLDecoder.decode(group3, "UTF-8");
		System.out.println("group1的值是："+group1);
		System.out.println("group2的值是："+group2);
		System.out.println("group3的值是："+group3);
		req.setAttribute("group1", group1);
		req.setAttribute("group2", group2);
		req.setAttribute("group3", group3);
		String sql1 = "select groupID from `group` where group1='"+group1+"' and group2='"+group2+"' and group3='"+group3+"'";
		ResultSet rs1 = dao.executeQuery(sql1);
		rs1.first();
		int groupID = Integer.parseInt(rs1.getString(1));
		String queType = req.getParameter("queType");
		queType = URLDecoder.decode(queType, "UTF-8"); 
		List<String> primarySchools = new ArrayList<String>(); 
		if (queType.equals("选择题") || queType.equals("填空题") || queType.equals("判断题") || queType.equals("解答题")) {
			String sql2 = "select * from question where groupID = '"+groupID+"' and queType = '"+queType+"' order by queID desc";
			ResultSet rs2 = dao.executeQuery(sql2);
			while (rs2.next()) {
				System.out.println("前进1");
				String queID = rs2.getString(1);
				String queTitle = rs2.getString(6);
				String queContent = rs2.getString(7);
				String queAnswer = rs2.getString(8);
				String queAnalysis = rs2.getString(9);
				String collection = "collection" + i;
				String queID2 = "queID" + i;

				String sql4 = "select comScore from comment where queID = '"+queID+"'";
				ResultSet rs4 = dao2.executeQuery(sql4);
				float comScore = 0;
				int k = 0;
				while (rs4.next()) {
					comScore += rs4.getFloat(1);
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
				if (rs2.getString(2) == null) {
					String userID = rs2.getString(3);
					String sql3 = "select userAccount from user where userID = '"+userID+"'";
					ResultSet rs3 = dao2.executeQuery(sql3);
					rs3.first();
					String userAccount = rs3.getString(1);		
					sql4 = "select userID,comContent from comment where queID = '"+queID+"'";
					System.out.println("queID的2值是："+queID);
					rs4 = dao2.executeQuery(sql4);
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
				
					String primarySchool = 
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
					primarySchools.add(primarySchool);		
				}
				else {
					String admin = "admin";		
					sql4 = "select userID,comContent from comment where queID = '"+queID+"'";
					System.out.println("queID的2值是："+queID);
					rs4 = dao2.executeQuery(sql4);
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
					String primarySchool = 
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
					primarySchools.add(primarySchool);						
				}
				req.setAttribute("primarySchools", primarySchools);
				req.setAttribute("i", i);
				++i;
			}

			if(!rs2.first()){
				String primarySchool = "";
				primarySchools.add(primarySchool);
				req.setAttribute("primarySchools", primarySchools);
				return SUCCESS;
			}
		}
		else {
			String sql2 = "select * from question where groupID = '"+groupID+"' order by queID desc";
			ResultSet rs2 = dao.executeQuery(sql2);
			while (rs2.next()) {
				System.out.println("前进3");
				String queID = rs2.getString(1);
				queType = rs2.getString(5);
				String queTitle = rs2.getString(6);
				String queContent = rs2.getString(7);
				String queAnswer = rs2.getString(8);
				String queAnalysis = rs2.getString(9);
				String collection = "collection" + i;
				String queID2 = "queID" + i;
				String sql4 = "select comScore from comment where queID = '"+queID+"'";
				ResultSet rs4 = dao2.executeQuery(sql4);
				float comScore = 0;
				int k = 0;
				while (rs4.next()) {
					comScore += rs4.getFloat(1);
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
				if (rs2.getString(2) == null) {
					String userID = rs2.getString(3);
					String sql3 = "select userAccount from user where userID = '"+userID+"'";
					ResultSet rs3 = dao2.executeQuery(sql3);
					rs3.first();
					String userAccount = rs3.getString(1);			
					
					sql4 = "select userID,comContent from comment where queID = '"+queID+"'";
					System.out.println("queID的2值是："+queID);
					rs4 = dao2.executeQuery(sql4);
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
					}
					String primarySchool = 
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
					primarySchools.add(primarySchool);
				}
				else {
					String admin = "admin";			
					sql4 = "select userID,comContent from comment where queID = '"+queID+"'";
					System.out.println("queID的2值是："+queID);
					rs4 = dao2.executeQuery(sql4);
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
					String primarySchool = 
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
					primarySchools.add(primarySchool);
		

				}
				req.setAttribute("primarySchools", primarySchools);
				req.setAttribute("i", i);
				++i;
				
			}
			if(!rs2.first()){
				String primarySchool = "";
				primarySchools.add(primarySchool);
				req.setAttribute("primarySchools", primarySchools);
				return SUCCESS;
			}
		}
		
		return SUCCESS;
	}

}
