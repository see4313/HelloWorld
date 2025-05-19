
package com.yedam.ref.app;

public class homework1 {
	public static void main(String[] args) {
		int[][] numAry = new int[3][5];
		// 임의의 숫자 생성.
		
		int sum = 0;
		int avg = 0;
		int max = 0;
		int count = 0;
		for (int outer = 0; outer < numAry.length; outer++) {
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100);	
				sum += numAry[outer][inner];
				
				if (max < numAry[outer][inner]) {
					max = numAry[outer][inner];
				}
				count++;
			}
		} avg = sum / count;
		System.out.println(avg);
		
		
		

	} // end of main
	
} //end of class