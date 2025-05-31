package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.SwimClass;

public class ClassDAO extends DAO {
	
	// 전체조회
	public List<SwimClass> select() {
		String sql = "select * from swim_class";

		getConnect();
		List<SwimClass> classlist = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				SwimClass member = new SwimClass();

				member.setClassLevel(rs.getNString("class_level"));
				member.setTeacher(rs.getNString("teacher"));
				member.setSubject(rs.getNString("subject"));

				classlist.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classlist;
	}

	// 과목등록
	public int insert(SwimClass swimclass) {
		String sql = "insert into swim_class (class_level, teacher, subject)" + "values(?,?,?)";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, swimclass.getClassLevel());
			psmt.setString(2, swimclass.getTeacher());
			psmt.setString(3, swimclass.getSubject());

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	} // end of insert

	// 목록
	public List<SwimClass> list(String level) {

		String sql = "select class_level, teacher, subject from swim_class where class_level = ?";

		getConnect();
		List<SwimClass> classlist = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, level);

			rs = psmt.executeQuery();

			while (rs.next()) {
				SwimClass member = new SwimClass();

				member.setClassLevel(rs.getNString("class_level"));
				member.setTeacher(rs.getNString("teacher"));
				member.setSubject(rs.getNString("subject"));

				classlist.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classlist;
	} // end of list

	// 수정
	public int update(SwimClass swimclass) {
		String sql = "update swim_class set subject = ? where subject = ?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, swimclass.getChsubject());
			psmt.setString(2, swimclass.getSubject());
					
			int r = psmt.executeUpdate();
			System.out.println(r);
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}return 0;

	} // end of update
	
	//삭제
	public int delete(SwimClass swimclass) {
		String sql = "delete from swim_class where subject = ?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,swimclass.getSubject());
			
			int r = psmt.executeUpdate();
			return r;
		} catch(SQLException e) {
			e.printStackTrace();
		} return 0;
	} // end of delete
	
	
}// end of classDAO
