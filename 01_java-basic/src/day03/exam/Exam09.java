
package day03.exam;

import java.util.Random;

public class Exam09 {
	public static void main(String[] args) {
		int num = new Random().nextInt(100) +1;
		System.out.printf("생성된 숫자(%d)은 %s 입니다.", 
				          num, 
				          (num % 2 == 0) ? "짝수" : "홀수");
	}
}













