package day04.exam;

import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 수 : ");
		int input1 = Integer.parseInt(sc.nextLine());
		System.out.print("입력 수 : ");
		int input2 = Integer.parseInt(sc.nextLine());

		for (int i = input1; i <= input2; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %-3d ", i, j, i * j);
			}
			System.out.println();
		}
	}
}
