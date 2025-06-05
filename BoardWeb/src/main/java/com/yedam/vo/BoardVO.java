package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 필드, 생성자, 메소드(getter, setter) 만들기
 * lombok 사용(설치, 실제라이브러리도 있어야함)
 */

//@Getter
//@Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 전체생성자

@Data // 전체생성자빼고 위에 생성한것들 한번에 만들어주는게 data

public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;

}
