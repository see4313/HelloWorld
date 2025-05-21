package com.yedam.board;
// 글추가, 수정, 삭제, 목록보기(기능 만들기)

import java.util.Scanner;

import com.yedam.Calendar;

/*
 * 추가(addBoard)
 * 수정 (modifyBoard) - 글번호묻기, 바뀔내용, 바뀔제목
 * 삭제(removeBoard) - 글번호
 * 목록(boardList) - 상세화면 조회
 *   /조회기능(글번호를 넣어주면 글반환해주는 메소드 만들기) getBoard
 * 순번 부여(nextSequence) - 현재글번호 +1
 */

public class BoardExe {
	// 필드
	private Board[] boards; // 데이터 저장된 곳 // =이름만 생성한것 // Board[] 여러가지 많은 글들을 담을수 있음
	Scanner scn = new Scanner(System.in);

	private int bno = 2; // 배열 인덱스를 2부터 지정 , 밑에 0,1은 존재해서

	// 생성자
	public BoardExe() {
		boards = new Board[100]; // 이름만 만든 보드에 값을 할당
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 30도입니다", "일동이");
		boards[1] = new Board(11, "자바가 힘들어요1.", "자바는 힘들지 않아요", "이동이");
		boards[2] = new Board(12, "자바가 힘들어요2.", "자바는 힘들지 않아요", "삼동이");
		boards[3] = new Board(13, "자바가 힘들어요3.", "자바는 힘들지 않아요", "사동이");
		boards[4] = new Board(14, "자바가 힘들어요4.", "자바는 힘들지 않아요", "오동이");
		boards[5] = new Board(15, "자바가 힘들어요5.", "자바는 힘들지 않아요", "육동이");
		boards[6] = new Board(16, "자바가 힘들어요5.", "자바는 힘들지 않아요", "칠동이");
		boards[7] = new Board(17, "자바가 힘들어요6.", "자바는 힘들지 않아요", "팔동이");
		boards[8] = new Board(18, "자바가 힘들어요7.", "자바는 힘들지 않아요", "구동이");
		boards[9] = new Board(19, "자바가 힘들어요8.", "자바는 힘들지 않아요", "십동이");
	} // end of boardExe

	// 메소드.
	void execute() {
		// 3번 기회 숙제. 2025
		// 아이디입력.
		// 비밀번호 입력.
//		boolean run = UserExe.login(null, null);
		// run = true 면 userEXe에 있는 uname, passwd 값을 사용자가 입력한값으로 출력의미
		// 사용자가 값을 입력해야기때문에 null,null 로 자리값만 마련해줌
		boolean run = true;

		for (int i = 0; i < 3; i++) {
			
			String id = userMessage("아이디를 입력");
			String pw = userMessage("비밀번호를 입력");
			if (!UserExe.login(id, pw)) { // = !true = false(맞게 입력했을때)
				if (i == 2) {
					System.out.println("3번 틀렸습니다");
					return;
				}
				System.out.println("아이디와 비밀번호를 확인하세요");
			} else {
				System.out.println("환영합니다");
				break;
			}
		} // end of for

		// while
		
		
		// 로그인 성공하면 while 문 실행

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println(" 1. 추가  2. 수정  3. 삭제  4.목록  5. 달력   6. 종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;

			case 2: // 수정
				modifyBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
			case 4: // 목록
				boardList();
				break;
			case 5: // 달력
				Calendar.showMonth();
				break;

			case 6: // 종료
				System.out.println("** end of prog **");
				run = false; // 반복문을 끝내기 위함
			default:
				System.out.println("메뉴를 다시 선택하세요.");

			}// end of switch
		} // end of while
	}// end of execute.

	// 기능
	// "글 번호를 입력하세요>> " 1
	// "제목을 입력하세요>> "오늘은 덥네요
	// "내용을 입력하세요>> " 오늘은 기온이 30도가 넘습니다...
	// "작성자를 입력하세요>> " 이동이
	// "추가성공"/ 안되면 "추가실패" 메세지출력

	void addBoard() {

		int no = nextSquence(); // Integer.parseInt(userMessage("글번호를 입력하세요"));

		String title = (userMessage("제목를 입력하세요"));

		String content = (userMessage("내용을 입력하세요"));

		String writer = (userMessage("작성자를 입력하세요"));

		// Board 인스턴스 선언하고 값을 지정.
		Board board = new Board(no, title, content, writer);

		// 배열에 저장
		boards[bno++] = board;
		System.out.println("추가성공");

	}// end of addBoard

	/* 기능 */
	// 글번호 제목 작성자
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
//		sort(); // 글번호 순서대로정리
		int page = 1;
		// while 반복문
		while (true) {

			int start = (page - 1) * 5; // 한 페이지에 5개의 목록만 보여지도록 변수 설정
			int end = page * 5; // 합이 10이 됨

			System.out.println("글번호           제목          작성자");
			System.out.println("===================================");
			for (int i = start; i < end; i++) { // 위에 페이지 변수를 설정
				if (boards[i] != null) {
					boards[i].showInfo(); // 메소드 호출 showinfo board에 만듬
				}
			}
			// 상세보기 추가
			System.out.println("---------------------------------");
			System.out.println("   상세보기: 글번호입력,(이전:p) (다음:n) 메뉴로 이동(q)");
			System.out.println("---------------------------------");
			String str = scn.nextLine();

			// 메뉴 or 상세
			if (str.equals("q")) {
				break; // return;
			} else if (str.equals("n")) { // 페이지를 한장씩 넘김
				page++;
			} else if (str.equals("p")) { // 페이지를 한장씩 뺌
				page--;
			} else {
				int no = Integer.parseInt(str); // no = 글번호

				// 배열에서 조회
				Board sboard = getBoard(no); // 반환되는 데이터타입이 board타입
				if (sboard == null) {
					System.out.println("조회결과 없음");
					return;
				}
				sboard.showAllInfo(); // 조회결과가 있으면 sboard 보여주겠다 의미
				// if 문부터가 밑에 for 문과 동일 의미

//			for (int i = 0; i < boards.length; i++) {
//				if (boards[i] != null && boards[i].getBoardNo() == no) {
//					boards[i].showAllInfo(); // board에서 만든 showAllInfo
//				}
//			}
			}

			System.out.println(); // 줄바꿈 용도

		} // end of boardList

	}// end of while
		// 수정

	void modifyBoard() {
		int bno = userMenu("수정할 글번호 입력");
		Board result = getBoard(bno); // result 는 참고하고있는 반환값
		if (result == null) {
			System.out.println("조회한 결과가 없습니다");
			return;
		}

		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용 입력");
		//
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정완료");

	} // end of modifyBoard

	// 삭제
	void removeBoard() {
		int bno = userMenu("삭제할 글번호를 입력");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null; // 배열의 위치에가서 null
				System.out.println("삭제완료");
			}
		}

	} // end of removeBoard

	// 단건조회(getBoard)
	// 글번호를 활용해서 배열에서 조회하고 Board타입으로 반환
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) { // null 이 아니라는 조건을 넣어주면 오류를 덜 냄 //배열에서 찾는 기능 for문
				return boards[i];
			}
		}
		return null; // 위에서 조건을 찾고 맞는 글번호가 없으면 null 값을 반환의미 // board타입이라서 0은 불가능
	}// end of getBoard

	// 사용자의 입력값을 반환(위에 있는건 간단하게) // 문자타입과 정수타입
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}

	// 순번생성
	int nextSquence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1; // 글번호를 입력받은값에서 +1씩해서 작은순으로 정렬해주겠담
	} // end of nextSquence.

	void sort() { // 목록을 역순으로 절이해주는 코드
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.

} // end of class
