package day07;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		Sub01 s01 = new Sub01();
		// 메서드 호출
		// 객체변수.메서드명
		s01.method01();
		s01.method02(100);
		s01.method03(1, 2);
		s01.method04('a');
		s01.method05("a");
		Random r1 = new Random();
		s01.method06(r1);
		
		s01.method06(new Random());
		
	}
}














