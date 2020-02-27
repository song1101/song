package chenglulu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import chenglulu.model.Mine;

public class CommonDAO {
	public CommonDAO() {};
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
	public List search(String hql) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		List lists=new ArrayList<>();
		try {
			conn=getConnection();
			rst=pstmt.executeQuery(hql);
			ResultSetMetaData md = rst.getMetaData();
	        int columnCount = md.getColumnCount();
			while (rst.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rst.getObject(i));
	            }
	            lists.add(rowData);
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
}
