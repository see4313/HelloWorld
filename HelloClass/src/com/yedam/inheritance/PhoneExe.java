package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		
		
		// 부모 클래스
		Cellphone phone1 = new Cellphone("It203", "red");
//		phone1.model = "IT203";
//		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());
		
		//자식클래스
		Smartphone phone2 = new Smartphone();
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();
		Smartphone phone3 = null;
		if (phone2 instanceof Smartphone) {
			phone3 = (Smartphone) phone2;  //( )자동형변환 = Casting
			// 부모타입을 자식타입으로 변환할때 casting사용 
			// 부모클래스의 것만 실행가능 하고 자식만이 가지고있는것은 실행 불가능
			phone2.channel = 3;
			phone2.watch();
			phone3.toString();
			System.out.println(phone3.toString());
		}
		
		//instanceOf 를 활용해 메소드를 변환가능한지 체크
		if (phone1 instanceof Smartphone) {
			phone2 = (Smartphone) phone1;
			phone3.channel = 3;
			phone3.watch();
		}
		
		
		
		
	} //end of main
}// end of class
