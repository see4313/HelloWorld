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
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;

/*
 * M-V-Control 역할 (controller역할을 survlet이 함)
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
		map.put("/boardList.do", new BoardListControl());   //글목록
		map.put("/board.do", new BoardControl());           //상세화면
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());  // 글수정화면
		map.put("/removeBoard.do", new RemoveBoardControl());  // 글삭제화면
		
		//member 관련
		map.put("/loginForm.do", new LoginFormControl()); // 화면
		map.put("/login.do", new LoginControl());        // id, pw 로그인처리
		map.put("/logout.do", new LogoutControl()); 

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url이 호출(http://localhost:8080/BoardWeb/boardList.do) ->어떤 페이지를 호출하고있는지 파악 -> Control.
		String uri = req.getRequestURI();  // uri는 (BoardWeb/boardList.do)을 말한다
		String context = req.getContextPath(); // BoardWeb or /HelloWorld
		String page = uri.substring(context.length());  // 웹페이지마다 주소 길이가 달라질수 있기 때문에 contextPath 사용
		Control sub = map.get(page);  // control(위에 new ~Control)객체를실행하겠다 의미
		sub.exec(req, resp);

	}
}
