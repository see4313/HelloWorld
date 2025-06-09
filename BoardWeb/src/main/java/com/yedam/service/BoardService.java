package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 업무단위의 처리
 * 업무에서 사용하는 ......용어 사용
 */
public interface BoardService {
	public List<BoardVO> boardList(int page);  // 목록조회
	public BoardVO getBoard(int bno);  // 단건조회
	public boolean registerBoard(BoardVO board);  // 등록기능
	public boolean modifyBoard(BoardVO board);     //수정기능
	public boolean removeBoard(int bno);     //삭제기능
	
	//(int bno) 원하는 조건만 불러오기
	// (BoardVO board) 전체를 불러오기
		

}
