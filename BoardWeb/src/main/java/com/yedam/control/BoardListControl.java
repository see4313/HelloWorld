package com.yedam.control;



import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		//boardList.do?page=2&searchCondition=W&keyword=guest
//		req.setAttribute("myName", "Hongkildong");
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;  // boardList.do => 1페이지 출력
		
		
		String sc = req.getParameter("searchCondition");
		sc = sc == null ? "" : sc;  // null인 경우 공백으로 처리
		String kw = req.getParameter("keyword");
		kw = kw == null ? "" : kw;
		kw = URLDecoder.decode(kw);   // 16진수 -> 한글로 변경
		
		//검색조건을 사용하기 위함
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		
		//데이터처리
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		
		//페이징 계산
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		//jsp페이지에 정보 전달
		req.setAttribute("blist", list);  //요청정보에 (req,resp) 의 값을 담아 boardList.jsp페이지로 전달
		req.setAttribute("pageInfo", paging);
		req.setAttribute("search", search);
		
		// 요청재지정(페이지이동)
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp); // forward 사용자와 한번 요청되고나면 계속해서 요청정보가 유지되는방법 . 예를들면 사용자가 한번 로그인했으면 로그아웃하기전까지 계속 로그인되어있는것
		
	}
	

}
