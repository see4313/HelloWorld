package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int bno);      // 목록
	public ReplyVO selectReply(int rno);   //단건조회
	public int insertReply(ReplyVO rno);   //추가       
	public int deleteReply(int rno);       //삭제
	

}

