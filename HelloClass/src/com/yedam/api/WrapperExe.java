package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		int num = 10;
		
		Integer num2 = 20; //이렇게 써도 상관 없음 boxing중   // new Integer(20);
		num = num2.intValue();
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str); // 자동형변환 발생 
		
		Integer num4 = new Integer(10);  // boxing = 기본 타입이 랩퍼타입으로	
		Integer num5 = new Integer(10);  // unboxing = 참조타입이 기본타입으로 
		System.out.println(num4.intValue() == num5.intValue());
		
		
	
		
		
	}// end of main
	
	
	
}//end of class
