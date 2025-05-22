package com.yedam.exception;

/*
 *  1) 일반 예외 - 컴파일러가 에러부분을 파악해서 알려줌
 *  2) 실행 예외 = 실행시점에 에러가 발생하는 경우
 *  예외에는 exception이 상위 클래스 ( 부모위에 object 와 비슷한)
 */
public class ExceptionExe {

	public static void main(String[] args) {
		//실행예외
		String numStr = "a";
		int num = 0;
		try {  // 문자열을 숫자로 바꿔주는
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {  // 예외가 발생하면 대체할 코드 // NumberFormatException= 예외가 발생했다는 의미
			System.out.println("예외 발생");
		}

		System.out.println(num); // 실행을 해서 문자가 사용이 안된다는 오류발생

//		try {
//			Class.forName("java.util.Scanner"); // 예외처리 안해주면 컴파일에러
//		} catch (ClassNotFoundException e) { // 예외처리 하기위해 try -catch사용
//			System.out.println("일반예외발생");
//		}
		
		
		// 일반예외 (에러에 마우스 올리면 예시(surround~)뜨는걸 누르면 조금은 해결해줌 정확도는 낮음)
		try {
			Class.forName("java.util.Scanner");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 에러에 대해 로그를 보여주는 메소드
		}
		
		System.out.println("end of prog");
	}// end of main

} // end of class
