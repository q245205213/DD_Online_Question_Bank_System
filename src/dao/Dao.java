package dao;
import java.sql.*;


public class Dao{
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/problem_base","root","13115012041") ;
			stat = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ResultSet executeQuery(String sql) {
		try {
			rs = stat.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return rs;
	}
	
	public int executeUpdate(String sql) {
		try {
			stat.executeUpdate(sql);
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
}

/*public class Dao {	
Connection con = null;
Statement stat = null;
ResultSet rs = null;
public Dao() {
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/problem_base","root","13115012041");
stat = con.createStatement();
} catch (Exception e) {
// TODO: handle exception
con = null;
}	
}
public ResultSet executeQuery(String sql) {
try {
rs = stat.executeQuery(sql);
} catch (Exception e) {
// TODO: handle exception
rs = null;
}
return rs;
}
public int executeUpdate(String sql) {
try {
stat.executeUpdate(sql);
return 0;
} catch (Exception e) {
// TODO: handle exception
}
return -1;
}
}*/