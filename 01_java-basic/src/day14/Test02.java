package day14;

import java.util.Calendar;

public class Test02 {
	public static void main(String[] args) {
//		Calendar c = new Calendar();   // 추상클래스 객체 생성 불가
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		// 정보 얻기
//		int year = c.get(1);
		int year = c.get(Calendar.YEAR);
//		int month = c.get(2) + 1;
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		// 요일
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		String[] dayWords = {"일", "월", "화", "수", "목", "금", "토"};
		/*
		String dayWord = "";
		switch(dayOfWeek) {
		case 1: dayWord = "일요일"; break;
		case 2: dayWord = "월요일"; break;
		case 3: dayWord = "화요일"; break;
		case 4: dayWord = "수요일"; break;
		case 5: dayWord = "목요일"; break;
		case 6: dayWord = "금요일"; break;
		case 7: dayWord = "토요일"; break;
		}
		*/
		System.out.printf("오늘은 %s요일 입니다.\n", dayWords[dayOfWeek - 1]);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		
		
	}
}














