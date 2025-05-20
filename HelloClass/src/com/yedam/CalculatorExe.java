package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal = new Calculator(); //인스턴트 생성 = 메모리상에 실체를 하나 생성하겠다는 의미
		int num1 = 10;
		String str = "♥";
//		cal.printStar(num1, str); // 매개값을 실행하는 영역에서 넣어줘야됨, calculator 에서 정해진 타입으로 출력 
		
		cal.printStar(num1, str);
		String result = cal.printStar(num1, str);
		System.out.println(result);
		
		
		double sum = cal.add(num1, 10.5);
		
		//메소드 추가
		int[] numAry = {10, 20, 30};
		sum = cal.add(numAry);
		
		//Member[] 중에서 포인트가 큰 회원을 반환하는 메소드 맞들기
		Member[] members = {new Member("user01", "홍길동", "1111", 1000)
			            	,new Member("user02", "김이동", "2222", 2200) //
			            	,new Member("user03", "김삼동", "3333", 3300) //
				            ,new Member("user04", "김사동", "4444", 2800) //
		};
		
		//반환 유형(Member), 매개변수(Member[])
		Member member = cal.getMaxPoint(members);
		member.showInfo(); // 멤버스패기지에서 public 해줘서 멤버스에서 showInfo 불러오기가 가능하다
		
		System.out.printf("id: %s, name:%s, phone: %s, point: %d\n", 
				 member.getMemberId(), member.getMemberName(), member.getPhone(), member.getPoint() );
				//
//		System.out.println("10"); // 다양하게 매개값을 반환할수 있는 이유는 메소드 타입을 여러가지 조건을 설정해서 
//		System.out.println(10);
//		System.out.println(sum);
		
	}//end of main
	
}//end of class
