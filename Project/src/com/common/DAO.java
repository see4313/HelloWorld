package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "project1";
	String pwd = "project1";
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	
	//connection 생성하는 메소드
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of getConnect
	
	public void disconnect() {
		try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
