package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String id = "project1";
	static String pwd = "project1";
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement psmt;
	
	//connection 생성하는 메소드
	public static void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of getConnect
	
	public static void disconnect() {
		try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
