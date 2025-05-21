package com.yedam.board;
// 글번호, 제목, 내용, 작성자. : 필드

//getter, setter 작성 : 메소드
//기본생성자, 전체매개값을 갖는 생성자

public class Board {
	private int boardNo; // 글번호를 담기위한 필드
	private String title; // 제목을 담기위한 필드
	private String content; // 내용을 담기위한 필드
	private String writer; // 작성자를 담기위한 필드

	// 생성자.
	public Board() {
	} // 기본생성자는 무조건 만들어줘야됨

	public Board(int boardNo, String title, String content, String write) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = write;
	}

	// getter, setter
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite() {
		return writer;
	}

	public void setWrite(String write) {
		this.writer = write;
	}
	
	//글번호, 제목, 작성자 => 간략출력
	public void showInfo() {
		//1	  날씨좋음     홍길동 가 출력되어야됨
		System.out.printf("%3d     %12s      %4s\n", boardNo, title, writer);
		
	}
	
	//상세보기
	public void showAllInfo() {
		//글번호. 5      작성자: 홍길동
		//제목: 날씨가 좋아요
		//내용: 오늘 30도가 넘는데도 좋아요
		String strFormat = " 글번호: %d     작성자: %s\n"; 
		strFormat += "제목: %s\n";  // 출력문에서 문자가 길어서 문자만 따로 
		strFormat += "내용: %s\n";
		System.out.printf(strFormat, boardNo, writer, title, content);
	}

} // end of class.
