package com.yedam.ref;

public class ArryExe1 {

	public static void main(String[] args) {
		test3();
	}// end of main.

	public static void test3() {
		// Math.random 활용해서 10~100 사이의 점수을 생성
		// 학생 10명의 점수를 생성해서 학생점수의 평균을 구하고 최고점수 구하기.
		// scoreAry 변수명.
		int sum = 0;
		int max = 0;
		int avg = 0;
		int scoreAry = (int)(Math.random() * 91) + 10;
		for (int i = 0; i <= 10; i++) {
			System.out.println("점수를 입력>>");
		}

	} // end of test3

	public static void test4() {
		// 정수배열 int배열 => intAry : 10, 17, 22, 31, 55, 24
		int[] intAry = { 10, 17, 22, 31, 55, 24 };
		int temp = 0;

		// 정렬
		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				if (intAry[i] > intAry[i + 1]) { // i+1 은 i 다음표시, 부등호에 따라 오름차순, 내림차순
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}

		// 출력
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("i: %d, 값: %d\n", i, intAry[i]);
		}
		if (temp != 0) {
			return;
		}

		// 최고값.
		int max = 0;
		for (int i = 0; i < intAry.length; i++) {
			// max와 배열요소를 비교, 큰 값을 max에 저장
			if (max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.printf("최대값은 %d\n", max);

		if (max != 0) {
			return;
		}

		// 합.
		int sum = 0;
		int cnt = 0; // 횟수.
//			for (int i = 0; i < intAry.length; i+= 2) //짝수의 값만 구하겠다는 의미 밑에 for와 의미 동일
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] % 2 == 0) {
				sum += intAry[i];
				cnt++;
				System.out.printf("sum: %d, i: %d\n 값: %d\n", sum, i, intAry[i]);
			}
		}
		double avg = 1.0 * sum / cnt;
		System.out.printf("평균: %.1f\n", avg);
	} // end of test4

	public static void test1() { // p.183 문제3
		boolean run = true;
		while (true) {
			int num = (int) (Math.random() * 6) + 1;
			int num2 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", num, num2);
			if (num + num2 == 5) {
				break;
			}
		}
		System.out.println("end");
	}// end of test1

	public static void test2() { // 문제 5번
		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (outer >= inner) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	} // end of test2

}// end of class
