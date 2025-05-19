
package com.yedam.ref.app;

public class homework1 {
	public static void main(String[] args) {
		
		int[][] numAry = new int[3][5];
		// 임의의 숫자 생성.

		int max = 0;

		for (int outer = 0; outer < numAry.length; outer++) {
			int sum = 0;
			double avg = 0;
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100);
				sum += numAry[outer][inner];

				if (max < numAry[outer][inner]) {
					max = numAry[outer][inner];
				}
			} 
			avg = sum * 1.0/ numAry[outer].length; // 정수를 실수로 변환할때 *1.0 사용 (둘 중에 하나라도 실수면 실수)
			System.out.printf("numAry[inner]의 평균은 %.2f\n ", avg);
		} // end of for.

	} // end of main
	
	
	

} // end of class