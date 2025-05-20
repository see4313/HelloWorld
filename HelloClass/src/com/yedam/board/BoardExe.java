package com.yedam.board;
// 글추가, 수정, 삭제, 목록보기(기능 만들기)

import java.util.Scanner;


public class BoardExe {
	// 필드
	private Board[] boards; // 데이터 저장된 곳 // =이름만 생성한것 // Board[] 여러가지 많은 글들을 담을수 있음 
	Scanner scn = new Scanner(System.in);
	
	private int bno = 2; // 배열 인덱스를 2부터 지정 , 밑에 0,1은 존재해서 
	
	//생성자
	public BoardExe() {
		boards = new Board[100]; // 이름만 만든 보드에 값을 할당
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 30도입니다", "일동이");
		boards[1] = new Board(11, "자바가 힘들어요.", "자바는 힘들지 않아요", "이동이");
	} // end of boardExe
	
	// 메소드.
	 void execute() {
		 boolean run = true;
		 while(run) {
			 System.out.println("------------------------------------");
			 System.out.println(" 1. 추가  2. 수정  3. 삭제  4.목록  5. 종료");
			 System.out.println("-------------------------------------");
			 System.out.print("선택>> ");
			 int selectNo = Integer.parseInt(scn.nextLine());
			 switch(selectNo) {
			 case 1: //추가
				 addBoard(); break;
				 
			 case 2: //수정
				 
				 
			 case 3: //삭제
				 
				 
			 case 4: //목록
				 boardList();
				 break;
				 
			 case 5: //종료
				 
				 
			 default:
					 System.out.println("메뉴를 다시 선택하세요.");
					 
			 }// end of switch
		 }// end of while
	 }// end of execute.
	 
	 //기능
	 //"글 번호를 입력하세요>> " 1
	 //"제목을 입력하세요>> "오늘은 덥네요
	 // "내용을 입력하세요>> " 오늘은 기온이 30도가 넘습니다...
	 //"작성자를 입력하세요>> " 이동이
	 //"추가성공"/ 안되면 "추가실패" 메세지출력
	 void addBoard() {
		 System.out.println("글 번호를 입력하세요>> ");
		 int no = Integer.parseInt(scn.nextLine());
		 
		 System.out.println("제목을 입력하세요>> ");
		 String title = scn.nextLine();
		 
		 System.out.println("내용을 입력하세요>> ");
		 String content = scn.nextLine();
		 
		 System.out.println("작성자를 입력하세요.");
		 String writer = scn.nextLine();
		 
	
		 //Board 인스턴스 선언하고 값을 지정.
		 Board board = new Board(no, title, content, writer);
		 
		 // 배열에 저장
		 boards[bno++] = board;
		 System.out.println("추가성공"); 
		 
	 }// end of addBoard
	 
	 /*기능*/
	 //글번호     제목      작성자
//	 ======================
//		1	  날씨좋음     홍길동
//		2    클래스 멋짐   김민규
//		3    자바 어려움   이동이
//		4   그래도 열심히    못해
//	 **등록된 글이 없습니다**
//	 -------------------------------------
//	 상세보기: 글번호입력, 메뉴로 이동(q)
//	 --------------------------------------
	 
	 void boardList() {
		 System.out.println("글번호           제목          작성자");
		 System.out.println("===================================");
		 for (int i = 0; i < boards.length; i++) {
			 if(boards[i] != null) {
				 boards[i].showInfo(); // 메소드 호출 showinfp board에 만듬
			 }
		}
		 // 상세보기 추가
		 System.out.println("---------------------------------");
		 System.out.println("상세보기: 글번호입력, 메뉴로 이동(q)");
		 System.out.println("---------------------------------");
		 String str = scn.nextLine();
		 
		 //메뉴 or 상세
		 if (str.equals("q")) {
			return;
		} else {
			int no = Integer.parseInt(str); // no = 글번호
			// 배열에서 조회
			for (int i = 0; i < boards.length; i++) {
				if (boards[i] != null && boards[i].getBoardNo() == no) {
					boards[i].showAllInfo(); // board에서 만든 showAllInfo
				}
			}
		}
		 
		 System.out.println(); // 줄바꿈 용도
		 
	 }// end of boardList
	
} // end of class
