package chenglulu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chenglulu.model.Order;
import chenglulu.model.Suggestion;
import chenglulu.model.User;

public class SuggestDAO {
	public SuggestDAO() {}
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
	public List findSugg() {
		List SuggList=new ArrayList<Order>();
		String sql="SELECT * FROM Suggestions WHERE isknown=0";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rst=null;
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			rst=stmt.executeQuery(sql);
			while(rst.next()){
				Suggestion sugg=new Suggestion();
				sugg.setSuggestionID(rst.getInt("suggestionID"));
				sugg.setSuggester(rst.getString("suggester"));
				sugg.setDescription(rst.getString("descriptions"));
				SuggList.add(sugg);
			}
			return SuggList;
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
}
