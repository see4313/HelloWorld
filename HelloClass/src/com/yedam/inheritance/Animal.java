package com.yedam.inheritance;
/*
 *  추상클래스(Animal) : 인스턴스 생성 불가능
 *                    추상메소드
 *                    
 * 자식클래스 : Bird, Fish
 */
public abstract class Animal { //abstract 추상클래스
	//Animal이라는 인스턴스는 생성불가능
	
	String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}
	
	//추상메소드 : 자식클래스에서 반드시 재정의 해야함
	public abstract void sound();
	
} // end of class
