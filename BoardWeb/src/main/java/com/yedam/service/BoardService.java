package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 업무단위의 처리
 * 업무에서 사용하는 ......용어 사용
 */
public interface BoardService {
	public List<BoardVO> boardList();  // 목록조회
	public BoardVO getBoard(int bno);  // 단건조회
	public boolean registerBoard(BoardVO board);  // 등록기능
		

}
