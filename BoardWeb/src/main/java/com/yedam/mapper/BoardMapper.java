package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 *  인터페이스(BoardMapper) - XML(BoardMapper.xml) 매칭.
 *  
 */

public interface BoardMapper {
	public List<BoardVO> selectList();     // 전체목록조회기능 사용X
	public List<BoardVO> selectListWithPaging(SearchDTO search);  // 페이지목록 만드는 기능
	public BoardVO selectBoard(int bno);   //단건조회기능 (게시글순서중에 하나를 눌렀을때)
	public int updateReadCnt(int bno);   // 조회 count 증가기능
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	// 건수를 나타내는 거라 int타입
	public int selectCount(SearchDTO search);     // 전체카운트조회
	
}
