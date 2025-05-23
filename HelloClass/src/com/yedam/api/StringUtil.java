package com.yedam.api;

public class StringUtil {

	public static String getGender(String string) {
//		String male = "남자";
//		String female = "여자";
//		char num =string.charAt();
//		switch(num) {
//		case '1':
//		case '3':
//			return male;
//		case '2':
//		case '4':
//			return female;
//			
//		}
//		
//		return null;
//		string.substring(string.length()-7, string.length());

		String str = string.substring(string.length() - 7, string.length()); 
		// substring(-여서 뒤에자리부터 7자리 짜르겠다의미(strat), )
		if (str.charAt(0) == '1' || str.charAt(0) == '3') {
			// 위에 str의 값에서 1이거나 3이거나 하면 남성을 리턴한다
			return "남성";
		}
		return "여성"; // 그게 아니면 여성을 리턴한다
	}

	public static Object getExtName(String string) {
		int num = string.indexOf("."); 
		//indexOf: 문자열 내에서 주어진 문자열의 위치를 리턴함
		// . 자리부터 리턴함
		
//		string.substring(num, string.length()); // .부터 뒤에 다 지운다의미
		return string.substring(num + 1, string.length());
//		return string.substring(num + 1, string.length()-2); // 뒤에서 2자리 빼고 출력됨
		//substring( .뒤에 한자리부터 다 리턴, 지금은 필요 없지만 뒷자리에서 부터 잘라야될때 필요)
	}
	
	//lastindexOf 를 활용하기
	

}
