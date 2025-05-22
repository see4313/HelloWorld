package HomeworkP;

public class practice1 {

// 필드

// 메소드 (addNum) ==> 기능만 만들어 놓은게 메소드....
	public int addNum(int num1, int num2) {
		int sum = num1 + num2;
		 return sum;
		
	} // end of addNum

	// 문자열 반환하는메소드
	public String str(String text1, String text2) {
		return text1 + text2;

	} // end of str

	// 매개변수 두개 중에서 뭐가 더 큰지 알려주는 메서드
	public int max(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else if (num1 < num2) {
			return num2;
		}
		return num1; 
	}
	// 평균
	public int avg(int num1, int num2) {
		return(num1 + num2) / 2;
		
	}
	
	
			
		

// 생성자 
} // end of class