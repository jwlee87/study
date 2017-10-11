package day02;

import java.util.Random;

public class NamingTest {
	public static void main(String[] args) {
		int i = Integer.parseInt("1");
		int j = Integer.parseInt("2");
		
		System.out.println(i + j);
		System.out.println(Integer.MAX_VALUE);
		Random r = new Random();
		System.out.println(r.nextInt(100));
	}
}
