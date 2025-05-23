package com.yedam.api;

public class MathExe {
	public static void main(String[] args) {
		// 절대값
		System.out.println(Math.abs(100));

		// 올림, 버림
		System.out.println(Math.floor(12.3)); // floor = 소수점이 있으면 버림
		System.out.println(Math.ceil(12.3)); // ceil = 소수점이있으면 올림
		System.out.println(Math.round(12.3)); // round = 소수점 반올림
		
		//크기비교
		System.out.println(Math.max(Math.ceil(12.3), Math.floor(12.3)));
		
	}

}// end of main
