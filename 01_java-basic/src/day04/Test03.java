package day04;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		// 반복문을 중간에 빠져나가기      : break
		// 반복문의 나머지 부분을 무시하기 : continue
		/*
		Random r = new Random();
		int num = r.nextInt(9) + 1;  // 1 ~ 9
		System.out.println("num : " + num);
		
		System.out.println("break");
		for (int i = 1; i < 10; i++) {
			System.out.println(i);
			if (i == num) break;
		}
		System.out.println("continue");
		
		for (int i = 1; i < 10; i++) {
			if (i == num) continue;
			System.out.println(i);
		}
		*/
		Random r = new Random();
		int breakNum = r.nextInt(4);
		/*
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
			for (int k = 0; k < 3; k++) {
				System.out.println("k = " + k);
				if (k == breakNum) {
					flag = true;
					break;
				}
			}
			if (flag == true) {
				break;	
			}
		}
		*/
		outer : 
		for (int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
			for (int k = 0; k < 3; k++) {
				System.out.println("k = " + k);
				if (k == breakNum) {
					break outer;
				}
			}
		}
	}
}






















