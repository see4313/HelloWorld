package com.yedam.inheritance;
/*
 * 부모클래스 : Animal(추상클래스)
 */
public class Bird extends Animal { // Animal(부모요소)에 extends bird(자식요소) 를 상속한다

	@Override
	public void sound() {
		// 부모클래스의 sound() 재정의 해야함
		System.out.println("짹짹");
		
		
	}

}
