package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 */
public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pwd = "tiger";

		// 세션
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
			System.out.println("연결성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Statement 객체
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "insert into product (p_code, p_name, p_price)\r\n"
				+ "values(201, '오레오', 15900)";
		String sql2 = "update product set p_price = 1590\r\n"
				+ "where p_code = 201";
		
		
		//업데이트
	
		
		//insert
		try {
			stmt = conn.createStatement();
			int r =stmt.executeUpdate(sql2);  //업데이트는 변경할때만 //executeUpdate를 호출할때는 insert, update, delete할때 사용
			if(r > 0) {
				conn.commit(); // 커밋
				System.out.println(r + "건 등록됨.");
			} else {
				conn.rollback(); // 커밋을 안하면 롤백해주겠다의미
			}
		} catch(SQLException e) {
			e.printStackTrace();   //에러가 났을떄 눈으로 봐야되서 넣음
		}
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");  // executeQuery를 호출할때는 조회할때만 사용
			System.out.println("상품코드    상품이름      가격");
			System.out.println("-------------------------");
			while (rs.next()) {
				System.out.println(rs.getInt("p_code") + " " + rs.getString("p_name") + " " + rs.getInt("p_price"));
			}
			System.out.println("--------end of rows---------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// end of main

} // end of class
