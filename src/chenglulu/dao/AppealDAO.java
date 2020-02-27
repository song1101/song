package chenglulu.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chenglulu.model.Appeal;
import chenglulu.model.Order;

public class AppealDAO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AppealDAO() {}
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
	public List findAppeals() {
		List appealList=new ArrayList<Order>();
		String sql="SELECT * FROM Appeal WHERE ishandled=0";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rst=null;
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			rst=stmt.executeQuery(sql);
			while(rst.next()){
				Appeal appeal=new Appeal();
				appeal.setAppealID(rst.getInt("appealID"));
				appeal.setOrderID(rst.getInt("orderID"));
				appeal.setReason(rst.getString("reason"));
				appeal.setDescriptions(rst.getString("descriptions"));
				appeal.setComplainant(rst.getString("complainant"));
				appeal.setBecomplainant(rst.getString("becomplainant"));
				appealList.add(appeal);
			}
			return appealList;
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}
	public void setAppealID(int appealID) {
		String sql="UPDATE Appeal SET ishandled=1 WHERE appealID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, appealID);
			pstmt.execute();
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
	public void setAppeal(Appeal appeal) {
		String sql="INSERT INTO Appeal VALUES(?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, appeal.getOrderID());
			pstmt.setString(2, appeal.getReason());
			pstmt.setString(3, appeal.getDescriptions());
			pstmt.setString(4, appeal.getComplainant());
			pstmt.setString(5, appeal.getBecomplainant());
			pstmt.setInt(6,appeal.getIshandled());
			pstmt.execute();
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
	public void cancelAppeal(int appealID) {
		String sql="DELETE FROM Appeal WHERE appealID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, appealID);
			pstmt.execute();
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
}
