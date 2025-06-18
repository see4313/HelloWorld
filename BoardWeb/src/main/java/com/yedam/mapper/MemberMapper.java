package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);  // 괄호 안에 "(id")는 MemberMapper에서의 #id를 의미함
	//회원목록
	public List<MemberVO> selectList(String order);
	
	//회원추가
	public int insertMember(MemberVO member);
	
	//회원조회(아이디로)
	public MemberVO selectMemberInfo(String id);

}
