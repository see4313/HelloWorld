package com.yedam;

//컨트롤+쉬프트+f 누르며 정렬
public class HelloJava {
	public static void main(String[] args) {
		//변수타입:int(정수타입), double(실수), boolean(참거짓)
		int num1 = 10; //변수를초기화한다.
		double num2 = 20; // 자동형변환(promotion)-작은데이터유형을 큰 데이터유형에 담을때는 가능
		
		num1 = (int) num2; //인트타입으로 강제형변환해주면 가능(casting)
		
		int num3 = 100;
		double num4 = 200;
		double result = (double)num3 + num4;  //자동형변환 , 같은 데이터타입끼리 연산가능
		System.out.println("결과는 " + result);
		
		//20 + 30 = >50
		System.out.println("결과는 " + 20 + 30); //문자열과 숫자라서 숫자도 문자로 생각하고 처리함
		
		//("결과는 " + (20 + 30)) 괄호로 묶어서 먼저 해주는건 상관 없음 그럼 숫자로 인식함 
		System.out.println("결과는 " + (20 + 30)); //=> 결과는 50
	}
}
