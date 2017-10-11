package day03.exam;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int val = Integer.parseInt(sc.nextLine());
		
		System.out.print("나눌 수를 입력하세요 : ");
		int val2 = Integer.parseInt(sc.nextLine());
		
		
		System.out.println("몫 : " + (val/val2) );
		System.out.println("나머지 : " + (val%val2));
		
	}
} 
