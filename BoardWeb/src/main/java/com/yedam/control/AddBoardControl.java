package com.yedam.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 한글처리방법
		req.setCharacterEncoding("utf-8");

		// 요청방식이 (get/post) 인지 구분해서 처리
		if (req.getMethod().equals("GET")) { // 비교할 값안에는 반드시 대문자사용
			// WEB-INF/jsp/addBoard.jsp를 통해 폼 열어줌

			req.getRequestDispatcher("user/addBoard.tiles").forward(req, resp); // getRequestDispatcher는 요청하는 요청페이지를 재지정함 forward 같이 사용
																						

		} else if (req.getMethod().equals("POST")) { // 글을 등록. 요청방법이 post
			// POST 요청
			// addBoard.serv?title= 제목&content=내용&writer=user01
			// => 페이지(?앞까지가 페이지주소) 뒤에 제목,내용,사용자까지 호출 , 두개이상 연결할떄는 &사용, 띄어쓰기 안함(내용에는 공백도
			// 포함가능)
			String title = req.getParameter("title");
			String contetnt = req.getParameter("content");
			String writer = req.getParameter("writer");

			// 메소드의 매개값
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(contetnt);
			board.setWriter(writer);

			// 업무서비스
			BoardService svc = new BoardServiceImpl();
			if (svc.registerBoard(board)) {
				System.out.println("등록성공");

				// 목록보여주는 페이지로 이동
				resp.sendRedirect("boardList.do");
			} else {
				System.out.println("등록실패");
			}
		} // end of if
	} // end of exec

} // end of class
