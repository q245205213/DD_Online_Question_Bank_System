package com.action;
import java.sql.*;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;
import com.action.UploadRecordReturn;
import com.action.AdminAuditRecordReturn;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private UploadRecordReturn urr = new UploadRecordReturn();
	private AdminAuditRecordReturn aarr = new AdminAuditRecordReturn();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	HttpSession session1 = req.getSession();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	private String account;
	private String password;
	private String password1;
	
	public String getAccount(){
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	
	// 用户登陆
	public void login(){
		if (getAccount().equals("admin")) {
			System.out.println(getAccount()+"in");
			String sql = "select * from admin where adminAccount='" + getAccount()+"'";
			System.out.println("admin:"+getAccount());
			ResultSet rs = dao.executeQuery(sql);
			try {
				rs.next();
				if (rs.getString(2).equals(getAccount())&&rs.getString(3).equals(getPassword())) {
					res.getWriter().write("admin");
					session.put("username", getAccount());	
					System.out.println("admin:"+getAccount());
//					审核用户上传题目
					aarr.adminAuditRecordReturn();
				}
				return;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		System.out.println("这是什么："+getAccount());
		String sql = "select * from user where userAccount='" + getAccount()+"'";
		ResultSet rs = dao.executeQuery(sql);
		System.out.println("a:"+getAccount());
		try {
			/*System.out.println("b"+rs.getString(2));*/
			if (getAccount().equals("")) {
				res.getWriter().write("null");
			}
			else if (rs.next()) {
				sql = "select * from user where userAccount='" + getAccount()+"' or userPassword ='"+getPassword()+"'";
				rs = dao.executeQuery(sql);
				rs.next();
				if (rs.getString(2).equals(getAccount())&&rs.getString(3).equals(getPassword())) {
					res.getWriter().write("success");
					session.put("username", getAccount());
//					调用上传记录
					urr.uploadRecordReturn();
//					显示个人信息
					String sql2 = "select * from user where userAccount='"+session.get("username")+"'";
					rs = dao.executeQuery(sql2);
					rs.next();
					String sql3 = "select * from userinfo where userID = '" +rs.getString(1)+"'";		
					rs = dao.executeQuery(sql3);
					while (rs.next()) {
						session.put("name", rs.getString(3));
						session.put("age", rs.getString(4));
						session.put("sex", rs.getString(5));
						session.put("identity", rs.getString(6));
						session.put("mobile", rs.getString(7));
						session.put("address", rs.getString(8));
						
					}		
				}
				else {
					res.getWriter().write(getAccount());
				}
				
				return;
			}
			else {
				System.out.println(getAccount()+" out");
				res.getWriter().write("false");
				return;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
	}
	// 用户注册
	public void regist() throws Exception {
		/*if(getPassword()!=getPassword1()){
			return "error";
		}*/
		System.out.println("zheshiyigecshi");
		if (getPassword()==null||getPassword().equals("")) {System.out.println("1"+getPassword1());
			return;
		}
		else if (!getPassword().equals(getPassword1())) {System.out.println("wwwww");
			return;
		}
		else{
			String sql = "insert into user(userAccount,userPassword) values('"+getAccount()+"','"+getPassword()+"')";
			
			int i = dao.executeUpdate(sql);
			System.out.println("i的值是："+i);
			if(i>-1){
				res.getWriter().write("aaa");
				System.out.println("aaa");
				
				String sql2 = "select * from user where userAccount='"+getAccount()+"'";
				System.out.println(sql2);
				ResultSet rs = dao.executeQuery(sql2);
				rs.next();
				System.out.println("返回的数据"+rs.getString(1));
				String sql3 = "insert into userinfo(userID) values('"+rs.getString(1)+"')";
				int ii = dao.executeUpdate(sql3);
				System.out.println("ii的值是:"+ii);
				return;
			}
			else {
				res.getWriter().write("bbb");
				System.out.println("bbb");
			}
			return;
		}
	}
	// 检测是否存在用户名
	public void checkUser(){
		String sql = "select userAccount from user where userAccount='"+getAccount()+"'";
		System.out.println(getAccount());
		ResultSet rs = dao.executeQuery(sql);
		
		try {
			if (rs.next()&&getAccount().length()!=0) {
				System.out.println("得到值"+rs);
				res.getWriter().write(getAccount());
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 注销
	public String cancel(){
		System.out.println("cancel的值是:"+session.get("username"));
		session1.invalidate(); 
		return "success";
	}	
	public String logo_index(){
//		System.out.println("login1");
		return "success";
	}

}