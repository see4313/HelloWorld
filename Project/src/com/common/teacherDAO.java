package com.common;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vo.Teacher;

public class teacherDAO extends DAO{
	
	public List<Teacher> select(String subject) {
		String sql = "select * from teacher where name = (select teacher from swim_class where subject = '"
				+ subject + "')";
		
		getConnect();
		List<Teacher> teacher = new ArrayList<>(); 
		
		try {
			psmt = conn.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			

			while (rs.next()) {
				 Teacher member = new Teacher();
				 
				 member.setName(rs.getString("name"));
				 member.setPhone(rs.getString("phone"));
				 member.setGender(rs.getString("gender"));
				 teacher.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
}
