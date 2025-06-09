package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/servlet/boardList.serv")  // 여기 적는 경로가 실행하는 경로(servlet안에 boardList)
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardList() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // HttpServletRequest요청정보,response 응답정보
		// 컨텐츠 담고 있는 정보 지정
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<h3>Hello</h3>");
		out.print("<p>나는 한글</p>");

		// 업무 서비스
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(1);
		
		out.print("<table border='1'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>작성자</th></tr><thead>");
		out.print("<tbody>");
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td aline='center'>" + list.get(i).getBoardNo()+ "</td>");
			out.print("<td><a href='../board.serv?bno=" +list.get(i).getBoardNo()+ "'>" + list.get(i).getTitle()+ "</a></td>");
			out.print("<td>" + list.get(i).getWriter()+ "</td>");
			out.print("</tr>");			
		}
		out.print("</tbody></table>");
		
		//index페이지로 이동하고 싶으면 링크 만들어주면 됨
		out.println("<a href='../index.html'>인덱스페이지</a>"); 
		
		//등록페이지로 이동링크
		out.println("<a href='../html/addForm.html'>등록페이지</a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
