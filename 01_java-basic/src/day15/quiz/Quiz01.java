package day15.quiz;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz01 {
	public static void main(String[] args) {
		// Set 을 활용한 로또 번호 추출
		// 1 - 45 사이의 랜덤하게 6개를 생성 후 출력
		Random r = new Random();
		Set<Integer> set = new HashSet<>();
		while (set.size() < 6) {
			set.add(r.nextInt(45) + 1);
		}
		System.out.println(set);
		
	}
}














