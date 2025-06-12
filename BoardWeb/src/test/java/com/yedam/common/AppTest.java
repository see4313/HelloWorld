package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		
		// 목록.
		List<ReplyVO> list = svc.replyList(221);
		for(ReplyVO reply : list) {
			System.out.println(reply.toString());
		}
		
		//단건조회
		ReplyVO rvo = svc.getReply(7);
		System.out.println(rvo.toString());
		
		
		//추가
		ReplyVO k = new ReplyVO();
		k.setBoardNo(221);
		k.setReplyer("테스트");
		k.setReply("내용입니다");
		svc.addReply(k);
		
//		//삭제
		svc.removeReply(7);
		
		
		
		
		
		
	}
}
