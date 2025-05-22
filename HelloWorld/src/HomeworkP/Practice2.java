package HomeworkP;

public class Practice2 {
	public static void main(String[] args) {
		
		practice1 num = new practice1();

		System.out.printf("두 수의 합은 %d입니다", num.addNum(10, 20));
		
		System.out.printf("평균값은 %d입니다", num.avg(30,5));
		
		System.out.printf("합은 %d, 최대값 %d, 평균값 %d",num.addNum(10, 30), num.max(67,49), num.avg(22, 2));
		
	
		
	}
}
