package com.yedam.inheritance;
/*
 * cellphone을 상속하는 class
 * 
 * extends는 상속하겠다의미 (extends 뒤에 부모클래스 적으면 생성됨)
 * cellphone 안에 smartphone 을 상속하겠다
 */ 
 
public class Smartphone extends Cellphone {  //자식(smartphone) extends 부모클래스(cellphone)
	int channel;
	// 생성자
	public Smartphone() {}
	//기본생성자
	public Smartphone(String model, String color, int channel) { // 자식클래스에는 생성자가 있는데 부모클래스에 생성자가 없으면 오류
		super(model, color);  // super = 부모호출
		this.channel = channel;
		}
	
	
	// 메소드
	void watch() {
		System.out.println(channel + "을 시청합니다");
	}
	// 부모클래스의 기능을 자식클래스에 재정의 => (overriding)
	@Override // @~ 있으면 부모가 있다는 의미
	public void powerOn() { // 부모가 public 이기에 자식도 public 
		//접근 제한자도 똑같이 하는게 좋고 부모보다 더 강한 접근자는 불가능
		//(ex. 부모가 public 인데 자식이 private는 불가능)
		
		System.out.println("🎁전원을 켭니다🎁");
	}
	@Override
	public void powerOff() {
		System.out.println("🎁전원을 켭니다🎁");
	}
	@Override
	public String toString() {
		return super.toString() + "Smartphone [channel=" + channel + "]";
		// super 해서 부모클래스도 사용하고 toString을 써서 부모와 자식요소를 합쳐준다는 의미 
		// super(부모)에는 모델과 색상
		// 자식에는 채널
	}


	
}// end of class
