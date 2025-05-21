package com.yedam.ref;
// 실행클래스
public class CalculatorExe {
	
	public static void main(String[] args) {
		int a = 20, b = 30;
		
		// sum의 기능 활용
		Calculator c1 = new Calculator(); // 인스턴스 생성
		c1.sum(a, b);   // sum은 정적 메소드
		
		Calculator.sum(a, b); 
		
//		CalculatorExe ce = new CalculatorExe();
//		ce.printStar();
		
	}// end of main
	
	static void printStar() { // 메인밖에 있어서 인스턴스가 만들어져야 사용가능
		System.out.println("*");
		
	} // end of printStar
	
} // end of class
