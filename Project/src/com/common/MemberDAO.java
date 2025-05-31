package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 데이터베이스에다가 정보를 입력
 */

import com.vo.Member;

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
			
			if(member.getMemberId().equals("")||member.getMemberName().equals("")|| member.getPhone().equals("")||member.getMemberDate().equals("") ) { 
				System.out.println("다시 입력하세요🥲");
				return 0;
			} 

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}
		return 0;
	} // end of insert

	// 수정
	public int update(Member member) {
		String sql = "update swim_member set member_name = ?, phone = ?, class_level = ?, class_time = ? where member_id = ?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getPhone());
			psmt.setString(3, member.getClassLevel());
			psmt.setString(4, member.getClassTime());
			psmt.setString(5, member.getMemberId());
			

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
		String sql = "select member_id, member_name, phone, class_level, class_time from swim_member";

		getConnect();
		List<Member> list = new ArrayList<Member>();
		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setClassLevel(rs.getString("class_level"));
				member.setClassTime(rs.getString("class_time"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	} // end of select

	// 삭제
	public int delete(Member member) {
		String sql = "delete from swim_member" + " where member_id = ?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getMemberId());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;

	} // end of delete

	
	//목록
	public List<Member> list(String id) {

		String sql = "select member_id, member_name, phone, member_date, class_level, class_time from swim_member where member_id = ?";
		
		getConnect();
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();

				member.setMemberId(rs.getNString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setMemberDate(rs.getString("member_date"));
				member.setClassLevel(rs.getString("class_level"));
				member.setClassTime(rs.getString("class_time"));
				
				list.add(member);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}

		return list;
		
	} // end of list
	
	
} // end of classMemberDAO
