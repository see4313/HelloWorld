package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * 데이터베이스에다가 정보를 입력
 */

import com.vo.Member;
import com.common.DAO;

public class MemberDAO extends DAO {

	public int insert(Member member) {
		String sql = "insert into swim_member (member_id, member_name, phone, member_date)" + "values(?,?,?,?)";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getMemberName());
			psmt.setString(3, member.getPhone());
			psmt.setString(4, member.getMemberDate());

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
		return 0;
	} // end of insert
	
	public int update(Member member) {
		String sql = "insert into swim_member (member_name, phone)" + "values(?,?)";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getPhone());

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
		return 0;
	}// end of update
	
	public List<Member> select() {
		String sql = "select * from swim_member";

		getConnect();
		List<Member> list = new ArrayList<Member>();
		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
		while(rs.next()) {
			Member member = new Member();
			member.setMemberId(rs.getNString("member_id"));
			member.setMemberName(rs.getString("member_name"));
			member.setPhone(rs.getString("phone"));
			member.setMemberDate(rs.getString("member_date"));
			member.setClassLevel(rs.getString("class_level"));
			member.setClassTime(rs.getString("class_time"));
		}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
		
	} // end of select
} // end of classMemberDAO
