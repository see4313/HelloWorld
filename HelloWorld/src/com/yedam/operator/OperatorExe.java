package com.yedam.operator;

public class OperatorExe {
	public static void main(String[] args) {
		test5();
		
	}

	// 연습1
	public static void test() {
		// 증가, 감소 연산자(++, --)
		byte num1 = -128;
		num1 = 127; // byte 는 127까지(0이포함되서 127) 담을 수 있기에 128이면 오류
		num1++; // 128으로 오바되면 다시 제일 작은 값으로 돌아옴
		System.out.println(num1);

		// char타입 = 문자타입을 숫자타입으로
		char ch1 = 'A'; // A== 65
		ch1 = 66;
		ch1 = '가';
		ch1 = 'A';
		ch1 = 'a';
		ch1 = 0x29D7;
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		}
	}// end of test

//연습2 정수타입: byte, short, long, int, char
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2); // int 타입인데 int타입보다 작은 byte에 담을려고하면 오류=> byte 타입으로 변경하거나 int타입으로 변경
		// 정수 연산의 기본은 int.
		System.out.println(sum); // byte 타입의 30이 출력

		// long 형
		long num3 = 10000000000L; // L 형 타입으로 출력
		long num4 = 100L;
		System.out.println(Integer.MAX_VALUE); // 정수(integer)가 담을수 있는 가장 큰값이 나옴==max_value

	}// end of test1

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		System.out.printf("num1 => %d, num2 => %d, result =>%d", num1, num2, result);

		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("참입니다."); // !부정연산자 를 붙이게되면 결과값 출력x
		}
		// == 부정은 !=, >(크다) 부정은 <=, >=(작다) 부정은 <.
		result = 30;
		if (!(result != 30)) { // != 아니다 의미
			System.out.println("\nresult 는 30보다 작거나 같다.");
		}
		
		if (!(--num1 > 10 || num2 <20)) {
			System.out.printf("num1 =7> %d", num1);
		}
		
	}// end of test2
	
	
	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i < 10; i++) {
			if(isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글(on -> off, off -> on으로), true면 false로 false면 true로(토글),
		}
		
	}//end of test3
	
	public static void test4() {
		int mon = 6; //월정보 입력
		System.out.println(" Sun Mon Tue Wen Thu Fri Sat");
		int space = getSpace(mon); // 날짜 시작에 공란이 없을 경우
		int lastDate = getLastDate(mon);
		
		//빈공간 출력.
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		//날짜 출력.
		for (int day = 1; day <= lastDate;  day++) {
			System.out.printf("%4d",day);  //nd 의 의미는 (___) n칸을 채워줌
			if((day + space) % 7 == 0) {  
				System.out.println(); // ==줄바꿈
			}
		}
		
	}//end of test4

	// "월"정보 입력하면 "공란" 반환하는 메소드. getSpace()
	public static int getSpace(int month) {
		int space = 0;
		if(month == 3) { //3월달
			space = 6;  //공백이 6개
		} else if(month == 4) { //4월달
			space = 2;   //공백이 2개
		} else if(month == 5) {
			space= 4;
		} else if (month == 7) {
			space = 2;
		}
		return space;
		
	} //end of getSpace.
	
	// "월"정보 입력하면 말일을 알려주는 메소드. getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		
		switch(month) {
		case 2:
			lastDate = 28; 
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
		}
		return lastDate;
	} // end of getLastDate.
	
	// 삼항 연산자
	public static void test5() {
		String pass = "";
		int score = (int) (Math.random() * 100);
	/*	if(score > 60) {
			pass = "합격";
		} else {
			pass = "불합격";
		}else {
		if (score < 20) {
		pass = "과락" ;
		} else {
		pass = "불합격"}
		*/
		// if문을 간편하게 사용 (위의 if문이랑 동일)
		pass = (score >= 60) ? (score >=80) ?  (score > 20) ?  "우수" : "합격" : "불합격" : "과락";
		
		
		System.out.printf("%d점은 %s\n", score, pass);
	} // test5
	
	
	
	
	
}// end of class
