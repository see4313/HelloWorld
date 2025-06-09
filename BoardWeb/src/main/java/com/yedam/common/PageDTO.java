package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//전체 게시글 토탈 건수를 가지고 페이징 계산하려고 만듬
	
	// 필드 선언할때 한번에 적어주는 것 가능
	private int start, end, currentPage;  //currentPage
	// start ~ end == 1page~ 10page
	private boolean prev, next;
	
	public PageDTO(int page, int totalCnt) {
		this.currentPage = page;   //3page
		this.end = (int)Math.ceil(1.0*page / 10) * 10;  // ceil: 올림
		this.start = this.end - 9;
		
		int realEnd = (int)Math.ceil(1.0*totalCnt / 5);  //계산상의 건수를 기준으로 실제 마지막페이지.
		this.end = this.end > realEnd ? realEnd : this.end;  // realEnd가 마지막페이지
		
		// 이전, 이후 페이지가 있는지 존재 체크 (next 
		this.prev = this.start > 1; // start페이지가 1이 아니면 무조건 존재함
		
		this.next = this.end < realEnd;
		
	}

}
