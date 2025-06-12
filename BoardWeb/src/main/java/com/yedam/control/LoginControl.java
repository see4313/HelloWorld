package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, pw 활용 -> 로그인
		String id = req.getParameter("mid");   // loginForm.jsp에 있는 mid를 가르침
		String pw = req.getParameter("pass");
		
		// 로그인 할겁니다
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.login(id, pw);
		
		//성공여부체크
		if(member != null) {  // 로그인성공	
			// 세션객체에 setAttribute("logId", member.memberId)
			HttpSession session = req.getSession();   // cookie 정보를 읽어와서 session이 만들어짐
			session.setAttribute("logId", member.getMemberId());  // session객체는 어느곳에서든지 접근 가능 (그래서 로그아웃하기전까지 다른곳으로 이동 가능)
			session.setAttribute("auth", member.getReponsibility()); 
			
			
			//권한에 따라 시작페이지를 차별화
			if(member.getReponsibility().equals("User")){
				resp.sendRedirect("addBoard.do");   // 정상적으로 등록되면 등록 화면으로 이동
			} else if(member.getReponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}
			
		} else {  // 로그인 실패
			req.setAttribute("msg", "ID와 PW를 확인하세요!");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);   // 로그인화면으로 다시이동
		}
		

	}

}
