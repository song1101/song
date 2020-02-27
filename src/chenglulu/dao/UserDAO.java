package chenglulu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chenglulu.model.User;

public class UserDAO {
	private static final String GET_ONE_SQL="SELECT account,password FROM Users WHERE account=? AND password=?";
	private static final String GET_TWO_SQL="INSERT INTO Users VALUES(?,?,?,?)";
	public UserDAO() {}
	public static Connection getConnection() {
		Connection conn=null;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dburl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CampusSharedServicesPlatformDB";
		String username="admin";
		String password="123456";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public boolean searchUser(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(GET_ONE_SQL);
			pstmt.setString(1, user.getAccount());
			pstmt.setString(2, user.getPassword());
			rst=pstmt.executeQuery();
			if(rst.next())
				return true;
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
	}
	public static void insert(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(GET_TWO_SQL);
			pstmt.setString(1,user.getAccount());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getNickname());
			pstmt.setString(4,user.getPhone());
			int cnt=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	public void update(String account,String newphone,String newpwd) {
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		String sql1="UPDATE Users SET phone=? WHERE account=?";
		String sql2="UPDATE Users SET password=? WHERE account=?";
		conn=getConnection();
		try {
			if (newphone!=null) {
				
				pstmt1=conn.prepareStatement(sql1);
				pstmt1.setString(1,newphone);
				pstmt1.setString(2, account);
				pstmt1.executeUpdate();
			}		
			if(newpwd!=null) {
				conn=getConnection();
				pstmt2=conn.prepareStatement(sql2);
				pstmt2.setString(1,newpwd);
				pstmt2.setString(2, account);
				pstmt2.executeUpdate();
			}	
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt2.close();
				pstmt1.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	}
}
