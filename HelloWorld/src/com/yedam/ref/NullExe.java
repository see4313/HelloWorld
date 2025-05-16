package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
		String str1 = "홍길동"; //힙에 문자열객체 홍길동으로 만들어짐 //new String("홍길동");이 맞는 표기지만 저것도 상관없음
		String str2 = null;		
		
//		System.out.println(str2.toString());
		
		//let ary = [10, "String", 11.2] - 자바스크립트에서는 여러개가 한번에 담길수 있었지만 
		
		//int [] => 정수를 담을수있는 배열타입이고 정수만 담을순 없음, ary는 변수이름, {} 배열타입으로 정수담기
		int[] ary = {10,20,30}; //변순선언과 초기화.  
		// 자바에서는 선언할때 정수는 정수끼리 문자는 문자끼리만 생성 가능 아니면 오류
		System.out.printf("ary배열의 크기%d", ary.length);
		
		int[] intAry; //변수선언.
		intAry = new int[]{40,50,60}; // 값할당.
//		intAry = {40,50,60}; //  이렇게는 사용 불가능
		
		// 첫번째 위치의 40 => 400.
		intAry[0] = 400;
		
		//인덱스 3 => 4번째 위치.
//		intAry[3] = 10; // 4번째는 없어서 범위 벗어난 에러뜸(ArrayIndexOutOfBoundsException~error)
		intAry[2] = 10;
		
		
		// for반복문.
		for (int i = 0; i < 3; i++) {
			System.out.printf("[%d]번째의 값: %d\n", i, intAry[i]);
		}
		
		
		//배열의 크기를 늘리는법(잘안쓰고 불편)
		//배열은 선언하면 크기가 고정, 크기를 변경하려면 새로 선언.
		intAry = new int[5];
		intAry[0] = 40;
		intAry[1] = 50;
		intAry[2] = 60;
		intAry[3] = 10;
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("intAry[%d]번째의 값: %d\n", i, intAry[i]);
		}
		
		//배열선언: double 값을 담는 배열 dblAry
		//10.2, 23.2, 34.5
		
		double[] dblAry = {10.2, 23.2, 34.5};
		for (int i = 0; i < 3; i++) {
			System.out.printf("dblAry[%d]번째의 값: %.1f\n", i, dblAry[i]);// f앞에 .1 소수점자리값표시
		} 
		
		String[] strAry = new String[10];  //{"hello", "World"};
		for (int i = 0; i < strAry.length; i++) {
			System.out.printf("strAry[%d]번째의 값: %s\n", i, strAry[i]);
		} 
		
		
		
		
		
	} //end of main.
} //end of class.
