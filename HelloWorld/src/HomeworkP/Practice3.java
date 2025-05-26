package HomeworkP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Student {
	private int studentNo;
	private int score;

	// 자동생성자
	public Student(int studentNo, int score) {
		this.studentNo = studentNo;
		this.score = score;

	}

	// getter
	public int getStudentNo() {
		return studentNo;
	}

	public int getScore() {
		return score;
	}

}

public class Practice3 {
	public static void main(String[] args) {
		List<Integer> num = new ArrayList<>();
		int sum = 0;
		int avg = 0;

		for (int i = 1; i < 6; i++) {
			num.add((int) (Math.random() * 10) + 1);
		}
		for (int i = 0; i < num.size(); i++) {
			sum += num.get(i);
		}
		System.out.printf("합계: %d", sum);  

		avg = sum / num.size();
		System.out.printf("평균: %d ", avg);

	}// end of main

	public static void practice4() {

		Map<Student, Integer> num = new HashMap<>();

		for (int i = 1; i < 11; i++) {
			num.put(new Student(i, 10), 20);

		}
		Set<Student> keyset = num.keySet();
		Iterator<Student> iter = keyset.iterator();

		while (iter.hasNext()) {
			Student key = iter.next(); // 반복요소 획득
			int value = num.get(key);

			System.out.printf("번호: %d, 점수: %d. 값: %d\n", key.getStudentNo(), key.getScore(), value);

		}

	}// end of practice4

	public static void practice3() {
		List<Student> num = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			num.add(new Student(i, 10));

		}
		for (int j = 0; j < num.size(); j++) {

//			System.out.print(num.get(j).getStudentNo());
//			System.out.println(num.get(j).getScore());
			System.out.printf("번호: %d, 점수: %d\n", num.get(j).getStudentNo(), num.get(j).getScore());
		}

	}

	public static void practice2() {
//		Map<Integer, Integer> map = new HashMap<>(); // Map 은 <키 : 값>

		Map<Student, String> map = new HashMap<>();
		// 추가
		Student std = new Student(1, 67);
		Student std1 = new Student(2, 89);
		Student std2 = new Student(3, 75);

		map.put(std, "홍길동");
		map.put(std1, "김민수");
		map.put(std2, "포차코");

		System.out.println(map.get(std2));

		if (map.containsKey(new Student(3, 75))) {

		}

//		//가져오기
//		map.get(3); // 인덱스 아니고 키값 그대로 
//		
//		map.put(2, 47); // 수정하고싶으면 추가하면 덮어씌워짐
//		
//		map.remove(3); // 삭제할때도 키값
//		

	} // end of practice2

	public static void practice1() {
		List<Student> num = new ArrayList<>(); // Student타입, 생성자를 통해서 값을 넣어줘됨

		Student std = new Student(1, 67); // 맨앞이 타입, 맨 뒤에가 생성자이름...
		Student std1 = new Student(2, 89);
		Student std2 = new Student(3, 75);

		num.add(std);
		num.add(std1);
		num.add(std2);

		num.get(1).getScore(); // 두번쨰 학생의 점수만 출력
		System.out.println(num.get(1).getScore());

	} // end of practice1

	public static void practice() {

		List<Integer> num = new ArrayList<>(); // 정수형태의 ArrayList 만들고,
		num.add(50);
		num.add(46);

		num.get(1); // 가지고 올때는 인덱스 숫자사용

		num.remove(0);

		num.set(0, 49);
		System.out.println(num.get(0));

	}// end of practice

} // end of class
