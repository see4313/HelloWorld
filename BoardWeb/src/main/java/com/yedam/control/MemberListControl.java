package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//정렬순서
		String order = req.getParameter("order");
		order = order == null ? "member_id" : order;  // 파마레타가 안넘어왔을경우 기준정렬은 id정렬.
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList(order);
		req.setAttribute("memberList", list);
		
		//출력하는 jsp 페이지
		req.getRequestDispatcher("WEB-INF/jsp/member/memberList.jsp").forward(req, resp);

	}

}
