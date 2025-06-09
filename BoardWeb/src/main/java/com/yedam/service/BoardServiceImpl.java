package com.yedam.service;
/*
 * BoardService에서 새로운 기능을 만들었으면 그거에 맞게 메소드를 하나 더 생성 해줘야 에러가 안뜸 
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(int page) {
		return mapper.selectListWithPaging(page);
	}

	@Override
	public BoardVO getBoard(int bno) { // getBoard가 하는건 조회랑 조회수증가 두가지 역할
		BoardVO board = mapper.selectBoard(bno); // 글번호 -> 조회
		if (board != null) {
			mapper.updateReadCnt(bno); // 글번호 -> 조회수증가
			sqlSession.commit(); // 커밋처리를 해서 데이터베이스에 반영
		}
		return board;
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		int r = mapper.insertBoard(board); // insertBoard역할은 처리된 건수 반환
		if (r == 1) {
			sqlSession.commit(); // 커밋처리
			return true;
		}
		return false;
	}
	
	//수정기능
	@Override
	public boolean modifyBoard(BoardVO board) { 
		int r = mapper.updateBoard(board);
		if(r == 1) {
			sqlSession.commit();  //커밋처리
			return true;
		}
		return false;
	}
	
	//삭제기능
	@Override
	public boolean removeBoard(int bno) {
		int r = mapper.deleteBoard(bno);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

}
