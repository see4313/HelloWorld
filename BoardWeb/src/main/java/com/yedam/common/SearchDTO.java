package com.yedam.common;

import lombok.Data;

//검색조건을 사용하기위함(page, searchCondition, keyword)

@Data
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
	

}
