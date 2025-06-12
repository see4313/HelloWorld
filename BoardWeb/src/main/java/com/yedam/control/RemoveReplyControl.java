package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rno(댓글번호)를 삭제
		String rno = req.getParameter("rno");
		
		// DB입력처리
				ReplyService svc = new ReplyServiceImpl();
				if (svc.removeReply(Integer.parseInt(rno))) {//등록이 되었을때 
					//{"retCode" : "Success"}
					resp.getWriter().print("{\"retCode\" : \"Success\"}");
				} else {  // 등록에 실패했을떄 
					//{"retCode" : "Fail"}
					resp.getWriter().print("{\"retCode\" : \"Fail\"}");
				}
	}

}
