package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		
		// 목록.
		List<ReplyVO> list = svc.replyList(213, 1);
		for(ReplyVO reply : list) {  // reply변수에 list의 값을 순서대로 ReplyVO의 타입으로 반복 
		System.out.println(reply.toString());
		}
		
		//단건조회
		ReplyVO rvo = svc.getReply(8);
		System.out.println(rvo.toString());
		
	
		
		//추가
		ReplyVO reply = new ReplyVO();
		reply.setBoardNo(8);
		reply.setReply("복습중입니다");
		reply.setReplyer("user01");
		svc.addReply(reply);
		
		
		//삭제
		svc.removeReply(9);
		
		
		
		
		
		
	}
}
