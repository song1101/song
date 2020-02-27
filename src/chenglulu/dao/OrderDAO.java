package chenglulu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import chenglulu.model.Order;

public class OrderDAO {
	private static final String GET_ONE_SQL="SELECT * FROM Orders WHERE isChecked=1 AND isCompleted=0 AND isGet=0";
	public OrderDAO() {}
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
	
	public List findOrders(){
		List OrdersList=new ArrayList<Order>();
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(GET_ONE_SQL);
			while(rst.next()){
				Order order=new Order(); 
				order.setOrderID(rst.getInt("orderID"));
				order.setTitle(rst.getString("title"));
				order.setOrders_type(rst.getString("order_type"));
				order.setPublisher(rst.getString("publisher"));			
				order.setStartTime(rst.getString("start_time"));
				order.setEndTime(rst.getString("end_time"));
				order.setCost(rst.getFloat("cost"));
				order.setDescription(rst.getString("descriptions"));
				order.setReceiver(rst.getString("receiver"));
				order.setReceivePhone(rst.getString("receive_phone"));
				order.setReceivePlace(rst.getString("receive_place"));					
				OrdersList.add(order);
			}
			return OrdersList;
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
	public void getOrder(String account,int orderID) {
		String sql="UPDATE Orders SET orders=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
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
	public List adminFindOrders() {
		String sql="SELECT * FROM Orders WHERE isChecked=0";
		List OrdersList=new ArrayList<Order>();
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
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
					
				OrdersList.add(order);
			}
			return OrdersList;
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
	
	public void setIsCheck(int orderID) {
		String sql="UPDATE Orders SET isChecked=1 WHERE orderID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderID);
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
	public void setIsGet(int orderID,String account) {
		String sql="UPDATE Orders SET isGet=1 WHERE orderID=?";
		String sql1="UPDATE Orders SET orders=? WHERE orderID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		try {
			conn=getConnection();
			System.out.println("aaaaaaaa");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderID);
			pstmt.execute();
			pstmt1=conn.prepareStatement(sql1);
			pstmt1.setString(1, account);
			pstmt1.setInt(2, orderID);
			pstmt1.execute();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt1.close();
				pstmt.close();
				conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
