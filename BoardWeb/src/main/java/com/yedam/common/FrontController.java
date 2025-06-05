package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

/*
 * M-V-Control 역할
 *  url패턴과 실행할서블릿을 <key,values>형식으로 관리
 *  
 */
public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>(); // 생성자

	}

	@Override
	public void init(ServletConfig config) throws ServletException { // init은 최초로 한번만 실행됨
		// boardList.do -> 글목록 출력 기능만들기 (.do는 web.xml에 입력되어있음)
		//처리순서가 중요
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/addBoard.do", new AddBoardControl());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url이 호출(http://localhost:8080/BoardWeb/boardList.do) ->어떤 페이지를 호출하고있는지 파악 -> Control.
		String uri = req.getRequestURI();  // uri는 (BoardWeb/boardList.do)을 말한다
		String page = uri.substring(9); // boardList.do <- 이값을 말함
		Control sub = map.get(page);  // control객체를 반환
		sub.exec(req, resp);

	}
}
