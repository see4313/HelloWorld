package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");  // 게시물에서 한글처리
		
		// 요청방식에 따라 GET요청이면 화면 open.
		//            POST요청이면 저장.
		String bno = req.getParameter("bno");      // bno 지정해줘야 ?bno~ 요청방식으로 사용 가능 (bno가 몇번 목록을 찾을건지의 변수)
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) { 
			//요청재지정(페이지이동)  modifyBoard.do?bno=23 방식으로 요청
			BoardVO board = svc.getBoard(Integer.parseInt(bno)); // 조회하기위한 용도
			req.setAttribute("board", board);                    // 조회하기위한 용도
			
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			svc.modifyBoard(board);  // 수정
			
			//목록페이지로 이동
			resp.sendRedirect("boardList.do");  //sendRedirect는 매개값이 없음 단순히 페이지만 보여주기위함 // 외부 사이트도 가능 RequestDispatcher는 우리가 만든 페이지에서만 사용 가능
		}

	}

}
