/*
1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
1회. 숫자를 입력하세요(1 - 1000) : 3
3보다 큰 값 입니다.
2회. 숫자를 입력하세요(1 - 1000) : 500
500보다 작은 값 입니다.
3회. 숫자를 입력하세요(1 - 1000) : 250
정답입니다.

1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
1회. 숫자를 입력하세요(1 - 1000) : 3
3보다 큰 값 입니다.
생략......
10회. 숫자를 입력하세요(1 - 1000) : 3
3보다 큰 값 입니다.
10회안에 맞추기 게임에 실패하였습니다.
정답은 85입니다.
 */
package day04.quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz021 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("1~1000까지의 숫자 맞추기");

		int ans = r.nextInt(1000) + 1;
		int num;
		int i = 0;
		for (; i <= 10; i++) {
			System.out.print("숫자를 입력하세요:");
			num = sc.nextInt();
			if (num == ans) {
				System.out.println("정답입니다.");
				break;
			} else
				System.out.printf("%d 보다 %s 수입니다.\n", num, (num < ans) ? "큰" : "작은");
		}
		if (i == 11) {
			System.out.printf("10회 초과, 정답은 %d 입니다.", ans);
		}
	}
}
