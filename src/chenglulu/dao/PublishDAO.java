package chenglulu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chenglulu.model.Order;

public class PublishDAO {
	private static final String GET_ONE_SQL="INSERT INTO Orders VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public PublishDAO() {}
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
	public static void publish(Order order) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(GET_ONE_SQL);
			pstmt.setString(1,order.getTitle());
			pstmt.setString(2,order.getPublisher());
			pstmt.setString(3,null);
			pstmt.setString(4, order.getOrders_type());
			pstmt.setString(5, order.getStartTime());
			pstmt.setString(6, order.getEndTime());
			pstmt.setString(7, order.getDescription());
			pstmt.setDouble(8, order.getCost());
			pstmt.setString(9,order.getReceiver());
			pstmt.setString(10, order.getReceivePhone());
			pstmt.setString(11, order.getReceivePlace());
			pstmt.setString(12,"");
			pstmt.setInt(13, 0);
			pstmt.setInt(14, 0);
			pstmt.setInt(15, 0);
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
