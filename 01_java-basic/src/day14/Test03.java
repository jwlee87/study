package day14;

import java.util.Calendar;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		// Calendar -> Date 객체를 얻기
		Date d = c.getTime();
		
		// Date의 시간정보를 이용해서 Calendar 시간을 설정
		c.setTime(d);
		
		long time = d.getTime();
		c.setTimeInMillis(time);
		
		/*
		int val = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(val);
		
		c.set(Calendar.MONTH, 1);
		val = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(val);
		
		c.set(Calendar.MONTH, 10);
		val = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(val);
		*/
		
		/*
		// 날짜 정보 변경
		c.set(2014, 1, 10);   // 2014.2.10
		
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
//		c.set(2014, 1, 1);   // 2014.2.1
		c.set(Calendar.DAY_OF_MONTH, 1);   // 2014.2.1
		
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.MONTH, -1);
		*/
		
	}
}















