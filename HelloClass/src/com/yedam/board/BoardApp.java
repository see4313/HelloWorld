package com.yedam.board;
/*
 * 게시판 비스꾸무리한거 만듬이슈...
 * Board: 글번호, 제목, 내용, 작성자.
 * boardExe : 글추가, 수정, 삭제, 목록보기(기능 만들기)
 * BoardApp : main메소드를 담고있는 실행클래스.
 */

public class BoardApp {
	public static void main(String[] args) {
		BoardExe exe = new BoardExe();
		exe.execute();
	}
}
