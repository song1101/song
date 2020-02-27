package chenglulu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chenglulu.model.Appeal;
import chenglulu.model.Order;

public class MineDAO {
	private static final String GET_ONE_SQL="SELECT * FROM Orders WHERE publisher=?";
	private static final String GET_TWO_SQL="SELECT * FROM Orders WHERE orders=?";
	private static final String GET_THREE_SQL="SELECT * FROM Appeal WHERE complainant=?";
	public MineDAO() {}
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
	public List getMyrelease(String account) {
		List lists=new ArrayList<Order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(GET_ONE_SQL);
			pstmt.setString(1, account);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				Order order=new Order(); 
				order.setOrderID(rst.getInt("orderID"));
				order.setTitle(rst.getString("title"));
				//order.setPublisher(rst.getString("publisher"));				
				order.setOrders_type(rst.getString("order_type"));
				order.setStartTime(rst.getString("start_time"));
				order.setEndTime(rst.getString("end_time"));
				order.setReceiver(rst.getString("receiver"));
				order.setReceivePhone(rst.getString("receive_phone"));
				order.setReceivePlace(rst.getString("receive_place"));
				order.setCost(rst.getFloat("cost"));
				order.setDescription(rst.getString("descriptions"));
				order.setOrders(rst.getString("orders"));
				lists.add(order);
			}
			return lists;
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
		return null;
	}
	public List getMyOrders(String account) {
		List lists=new ArrayList<Order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(GET_TWO_SQL);
			pstmt.setString(1, account);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				Order order=new Order(); 
				order.setOrderID(rst.getInt("orderID"));
				order.setTitle(rst.getString("title"));
				order.setPublisher(rst.getString("publisher"));				
				order.setOrders_type(rst.getString("order_type"));
				order.setStartTime(rst.getString("start_time"));
				order.setEndTime(rst.getString("end_time"));
				order.setReceiver(rst.getString("receiver"));
				order.setReceivePhone(rst.getString("receive_phone"));
				order.setReceivePlace(rst.getString("receive_place"));
				order.setCost(rst.getFloat("cost"));
				order.setDescription(rst.getString("descriptions"));
				//order.setPublisher(rst.getString("orders"));
				lists.add(order);
			}
			return lists;
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
		return null;
	}
	public List getMyAppeal(String account) {
		List lists=new ArrayList<Order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(GET_THREE_SQL);
			pstmt.setString(1, account);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				Appeal appeal=new Appeal();
				appeal.setAppealID(rst.getInt("appealID"));
				appeal.setOrderID(rst.getInt("orderID"));
				appeal.setReason(rst.getString("reason"));		
				appeal.setDescriptions(rst.getString("descriptions"));
				lists.add(appeal);
			}
			return lists;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public void delMyrelease(String account) {
		
	}
	public void delMyOrders(String account) {
		
	}
	public void delMyAppeal(String account) {
	
	}
}
