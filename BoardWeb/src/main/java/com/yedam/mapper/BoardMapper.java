package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 *  인터페이스(BoardMapper) - XML(BoardMapper.xml) 매칭.
 *  
 */

public interface BoardMapper {
	public List<BoardVO> selectList();     //목록조회기능
	public BoardVO selectBoard(int bno);   //단건조회기능 (게시글순서중에 하나를 눌렀을때)
	public int updateReadCnt(int bno);   // 조회 count 증가기능
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	// 건수를 나타내는 거라 int타입
	
}
