package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession sqlSesion = DataSource.getInstance().openSession();
	
	MemberMapper mapper = sqlSesion.getMapper(MemberMapper.class);

	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberList(String order) {
		return mapper.selectList(order);
	}

	@Override
	public boolean addMember(MemberVO member) {
		int r = mapper.insertMember(member);
		if(r==1) {
			sqlSesion.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean getMemberInfo(String id) {  //회원조회
		MemberVO member = mapper.selectMemberInfo(id);
		if(member != null) {
			return true;
		}
		return false;
	}
	
	

}
