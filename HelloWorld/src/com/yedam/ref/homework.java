package com.yedam.ref;

import java.util.Scanner;

public class homework {
	static Student[] scores = null; // 학생점수저장.

	public static void main(String[] args) {
		init();
		name();
	}

	public static void name() {

		boolean run = true; // 반복문 실행/종료
		int studentNum = 0; // 학생수
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.학생 수 | 2.점수 입력 | 3.점수 리스트(성별) | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine()); // 사용자가 입력한 값이 문자타입인걸 정수타입을 바꿔주는게 integer.parseint
			// 배열의 선언없이 메뉴를 선택할 경우에는 NullPoniter 예외.
			if (scores == null) {
				if (selectNo == 2 || selectNo == 3 || selectNo == 4)
					System.out.println("학생수를 지정하세요.");
				continue;
			}
			if (selectNo == 1) {
				System.out.println("학생수"); // 학생수 지정.
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new Student[studentNum]; // 배열의 크기 지정. // new~ 주소값을 가지고 있다.

			} else if (selectNo == 2) { // 점수입력.
				for (int i = 0; i < studentNum; i++) { // studentNum = scores.length ? , //length 배열의 크기
					System.out.printf("scores[%d] 이름>> ", i);
					String name = scanner.nextLine(); // 이름저장
					// ---------------이름입력 부분
					System.out.printf("scores[%d] 점수 >> ", i);
					int score = Integer.parseInt(scanner.nextLine());
					// ===========점수입력부분
					// Double.parseDouble("(ex)175.6"); => 문자를 실수타입으로 변환해주는 식
					System.out.printf("scores[%d] 키 >> ", i);
					double height = Double.parseDouble(scanner.nextLine());

					System.out.printf("scores[%d] 성별 >> ", i);
					String gender = scanner.nextLine(); // 성별저장

					Gender gen = Gender.MALE;

					if (gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}

					// 인스턴스 생성
					Student student = new Student();
					student.studentName = name;
					student.score = score;
					student.height = height;
					student.gender = gen;
					scores[i] = student; // 배열에 저장하기

//					System.out.println(); // 줄바꿈용. , 줄바꿈은 필요 없음

				}

			} else if (selectNo == 3) { // 목록
				// 배열의 합이 0이면 점수를 입력하세요.
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수 누적. // scores 의 score만 누적
				}
				// 점수 입력하도록 메세지 보여주기
				if (sum == 0) {
					System.out.println("점수를 입력하세요.");
					continue; // 점수가 0일때 점수를 다시 입력하게끔 다시 while문 시작으로 돌아가는거
				}
				System.out.print("검색조건 ex) 남 또는 여 >> ");
				String keyword = scanner.nextLine(); // "남", "여", "엔터"
				Gender gen = Gender.MALE; // 초기화
				if (keyword.equals("남") || keyword.equals("남자")) { // 남 또는 남자 이건 다 검색 하게 한다
					gen = Gender.MALE;
				} else if (keyword.equals("여") || keyword.equals("여자")) {
					gen = Gender.FEMALE;
				}

				// "이름, 점수" 출력
				for (int i = 0; i < scores.length; i++) {
					if (keyword.equals("") || gen == scores[i].gender) { // keyword.equals("") == 엔터치면 다 보여주겠다 || 뒤에는 남
																			// 또는 여자 입력값에 맞게 보여주겠다
						System.out.printf("scores[%d]> 이름: %s 점수: %d 키: %.2f\n ", i, scores[i].studentName,
								scores[i].score, scores[i].height); // 위에서 이름과
					}
					// 점수입력했으니
					// 이름과 점수 출력

				}
			} else if (selectNo == 4) { // 분석 (최고점수, 평균)
				int max = 0; // 최고점수, 합계 변수 선언
				double avg = 0; // 평균변수 선언
				int sum = 0; // 합계변수 선언인데 위에 int에 사용가능

				double height = 0;
				double max2 = 0; // 실수타입의 변수도 하나 더 만들어주기
				Student maxStd = new Student(); // 최고점수를 받은 학생의 정보를 저장
				Student maxStd2 = new Student(); // 최고키를 가진 학생의 정보를 저장
				for (int i = 0; i < studentNum; i++) {
					sum += scores[i].score; // 점수 누적
					if (scores[i].score > max) {
						max = scores[i].score; // max값이 커질때마다 값을 변경하겠다
						maxStd.score = scores[i].score;
						maxStd.studentName = scores[i].studentName;

					}
					if (scores[i].height > max2) {
						max2 = scores[i].height;
						maxStd2.height = scores[i].height;
						maxStd2.studentName = scores[i].studentName;
					}

				}
				avg = (sum * 1.0) / scores.length; // 평균값 int 실수로 변경할떄 () * 1.0
				System.out.printf("학생이름: %s, 키: %.1f\n 평균점수: %.2f\n", maxStd2.studentName, maxStd2.height, avg); // 밑에
																													// 주석과
																													// 합쳐서
																													// 사용가능

			} else if (selectNo == 5) {
				run = false;
			}
		}

		System.out.println("프로그램 종료");

	}// end of name

	public static void init() {

		Student s1 = new Student(); // 인스턴스 생성. => 값을 담기위함
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;

		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.3;
		s2.gender = Gender.FEMALE;

		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE;

		scores = new Student[] { s1, s2, s3 }; // 초기데이터

	} // end of init

	public static void name1() {
		// 숫자 세 개 입력 받아서 입력받은 애들을 더해서 합계, 평균 구하기
		int sum = 0;
		int avg = 0;
		int max = 0;

		Scanner scanner = new Scanner(System.in);
		System.out.println("값을 입력하세요");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.println("다른값을 입력하세요");
		int num2 = Integer.parseInt(scanner.nextLine());

		System.out.println("값을 하나 더 입력하세여");
		int num3 = Integer.parseInt(scanner.nextLine());

		if ((num1 < 3) || (num2 < 3) || (num3 < 3)) {
			System.out.println("3보다 작은값이 있습니다");
		} else {
//		 num1 + num2 = sum; // 수학적 의미
			sum = num1 + num2 + num3; // 프로그래밍적 의미
			avg = sum / 3;
			System.out.printf("합계: %d,\n 평균: %d", sum, avg);
		}

	} // end of name;

	public static void name2() {
		// 배열
		// 정수값을 담을 값 5개
		int[] name = new int[5];
		// 배열 이름은 name2, 형태는 문자열 크기가 정해지지 않음
		String[] name2 = null; // 크키가 없는 배열은 =null;
		name2 = new String[10];

		int[] name3 = { 1, 2, 3, 4, 5 }; // 변수 값선언
		name3[3] = 10;
		for (int i = 0; i < name3.length; i++) {
			System.out.println(name3[i]);
			name3[i] = 5;

		}
		for (int i = 0; i < name3.length; i++) {
			System.out.println(name3[i]);

		}
		int[] name4; // 크기는 없고 배열만 선언.
		name4 = new int[] { 1, 2, 3 }; // 값을 넣어서 크기설정하면 값도 들어가고 크기도 들어감

		// 배열 이름은 std, 크기는 3, 배열에 학생 3명을 입력해서 넣기
		String[] std = new String[3];
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < std.length; i++) {
			System.out.println("학생이름을 입력해주세요");
//			String list  = scn.nextLine();
			std[i] = scn.nextLine();
		}
		for (int i = 0; i < std.length; i++) {
			System.out.println(std[i]);
		}
		// 숫자를 입력받고
		System.out.println("숫자를 입력하세요");
		int num1 = Integer.parseInt(scn.nextLine());

		if ((num1 == 1) || (num1 == 2) || (num1 == 3)) {
			System.out.println(std[num1 - 1]);
		} else {
			System.out.println("목록에 없습니다");
		}

	} // end of test2

	// while 문
	public static void name3() {
		boolean run = true;

		// 값을 입력 받아서 종료 입력하면 종료됨뜨게하기
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("값을 입력하세요");
			String num = scn.nextLine();
			if (num.equals("종료")) { // equals 문자열비교함수 (문자=문자)
				System.out.println("종료되었습니다");
				run = false; // = break; 동일 의미 boolean타입 둘다 사용가능.
			}
		}

	} // end of name3.

	// case
	public static void name4() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("번호를 입력하세요 1,2,3,4");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1:
				System.out.println("1번입니다");
				break;
			case 2:
				System.out.println("2번입니다");
				break;
			case 3:
				System.out.println("3번입니다");
				break;
			case 4:
				System.out.println("종료");
				run = false; // run이 false로 바뀜
				break; // break 걸리면서 스위치케이스문 종료 => while문은 false 이기때문에 반복 종료

			default:
				System.out.println("1~4까지만 입력해주세요");
			}
		}

	}// end of name4

}// end of homework
