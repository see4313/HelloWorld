package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글등록. 
		// 원본댓글, 댓글작성자, 댓글
		resp.setContentType("text/json;charset=utf-8");   // 웹화면에서 한글로 처리되게해주는 컨텐트타입
		String bno = req.getParameter("bno");      // 원본글에대한 번호
		String reply = req.getParameter("reply");    // 댓글의 내용
		String replyer = req.getParameter("replyer");  // 댓글의 작성자
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		
		// DB입력처리
		ReplyService svc = new ReplyServiceImpl();
		if (svc.addReply(rvo)) {//등록이 되었을때 
			//{"retCode" : "Success"}
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		} else {  // 등록에 실패했을떄 
			//{"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
		
		
		
	}

}
