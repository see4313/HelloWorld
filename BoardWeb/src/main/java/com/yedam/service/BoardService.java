package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

/*
 * 업무단위의 처리
 * 업무에서 사용하는 ......용어 사용
 * 
 * 	//(int bno) 원하는 조건만 불러오기
	// (BoardVO board) 전체를 불러오기
 */
public interface BoardService {
	public List<BoardVO> boardList(SearchDTO search);  // 목록조회
	public BoardVO getBoard(int bno);  // 단건조회
	public boolean registerBoard(BoardVO board);  // 등록기능
	public boolean modifyBoard(BoardVO board);     //수정기능
	public boolean removeBoard(int bno);     //삭제기능
	
	public int getTotalCount(SearchDTO search);            //전체 카운트계산(매개값은 없음)
	public List<Map> chartCount();
	
	//event
	public List<EventVO> eventList();
	public boolean addEvent(EventVO event);
	public boolean removeEvent(EventVO event);

	
	
	
		

}
