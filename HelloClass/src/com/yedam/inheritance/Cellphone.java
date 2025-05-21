package com.yedam.inheritance;
/*
 * 부모: Cellphone
 *     - 전원켜기, 전원끄기, 통화 == 볼륨up, 볼륨 down
 *     -모델명, 색상, 
 * 자식: Smartphone
 *     - TV보기 
 *     
 *     
 */      
public class Cellphone extends Object { // object가 부모보다 상위메소드
	String model;
	String color;
	
	// 생성자
	public Cellphone() {}  //기본생성자 => (()매개변수 없이 쓰겠다)
	public Cellphone (String model, String color) {
		this.model = model;  //this를 붙이는 이유는 클래스안에 있는거라는의미
		this.color = color;
	}
	
	
	public void powerOn() {
		System.out.println("전원 켜기");
	}
	public void powerOff() {
		System.out.println("전원 끄기");
	}
	void 통화하기() {
		System.out.println("통화 하기");
	}
	
	//toString()  오버라이딩 (소스 => genera~ toString 누르면 생성)
	@Override
	public String toString() { // super는 부모를 가르킴
		return "Cellphone [model=" + model + ", color=" + color + "]";
	}
	
	
	
}// end of cellphone
