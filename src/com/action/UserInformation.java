package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import java.net.URLDecoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;

public class UserInformation extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse res = ServletActionContext.getResponse();
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	private String name;
	private String age;
	private String sex;
	private String identity;
	private String mobile;
	private String address;

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAge(){
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public String getSex(){
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile(){
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdentity(){
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getAddress(){
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public String userInformation() throws Exception{

		String name = URLDecoder.decode(getName(), "utf-8"); 
//		String age = URLDecoder.decode(getAge, "utf-8"); 
		String sex = URLDecoder.decode(getSex(), "utf-8"); 
		String identity = URLDecoder.decode(getIdentity(), "utf-8"); 
//		String mobile = URLDecoder.decode(getName(), "utf-8"); 
		String address = URLDecoder.decode(getAddress(), "utf-8"); 
		String sql2 = "select * from user where userAccount='"+session.get("username")+"'";
		System.out.println("我是有用的"+name+"其他的："+getName());
		
		if (!getName().equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql = "update userinfo set userName = ('"+name+"') where userID = '" +rs.getString(1)+"'";		
			dao.executeUpdate(sql);
			System.out.println("getName的值是："+sql);
		}
		if (!getAge().equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql = "update userinfo set userAge = ('"+getAge()+"') where userID = '" +rs.getString(1)+"'";		
			int i = dao.executeUpdate(sql);
			System.out.println("getAge的值是："+i);
		}
		if (!getSex().equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql = "update userinfo set userSex = ('"+sex+"') where userID = '" +rs.getString(1)+"'";		
			int i = dao.executeUpdate(sql);
			System.out.println("getSex的值是："+i);
		}
		if (!getIdentity().equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql = "update userinfo set userIdentity = ('"+identity+"') where userID = '" +rs.getString(1)+"'";		
			int i = dao.executeUpdate(sql);
			System.out.println("getIdentity的值是："+i);
		}
		if (!getMobile().equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql = "update userinfo set userMobile = ('"+getMobile()+"') where userID = '" +rs.getString(1)+"'";		
			int i = dao.executeUpdate(sql);
			System.out.println("getMobile的值是："+i);
		}
		if (!getAddress().equals("")) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			System.out.println("rs1的值是："+rs.getString(1));
			String sql = "update userinfo set userAddress = ('"+address+"') where userID = '" +rs.getString(1)+"'";		
			int i = dao.executeUpdate(sql);
			System.out.println("getAddress的值是："+i);
		}
		if (true) {
			ResultSet rs = dao.executeQuery(sql2);
			rs.next();
			String sql3 = "select * from userinfo where userID = '" +rs.getString(1)+"'";		
			rs = dao.executeQuery(sql3);
			List<String> infoReturn = new ArrayList<String>();
			while (rs.next()) {
				infoReturn.add(new String(rs.getString(3)));
//				System.out.println("rs的值是："+rs.getString(3));
//				infoReturn.add(new String(rs.getString(4)));
//				infoReturn.add(new String(rs.getString(5)));
//				infoReturn.add(new String(rs.getString(6)));
//				infoReturn.add(new String(rs.getString(7)));
//				infoReturn.add(new String(rs.getString(8)));
				session.put("name", rs.getString(3));
				session.put("age", rs.getString(4));
				session.put("sex", rs.getString(5));
				session.put("identity", rs.getString(6));
				session.put("mobile", rs.getString(7));
				session.put("address", rs.getString(8));
				
			}		
			
//			req.setAttribute("test", infoReturn);
			session.put("test", infoReturn);
			System.out.println("infoReturn的值是："+infoReturn);
		}
		
		return "success";
	}
}
