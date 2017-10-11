package day04;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		/*
		 *       화면 출력>
		 *       **********
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("별의 개수 : ");
		int count = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= count; i++) {
			// 공백 찍기
			for (int k = 1; k <= count - i; k++) {
				System.out.print(" ");
			}
			
			// 별찍기
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();		
		}
		/*
		for (int i = 1; i <= 1; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 1; i <= 2; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 1; i <= 3; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 1; i <= 4; i++) {
			System.out.print("*");
		}
		*/
	}
}











