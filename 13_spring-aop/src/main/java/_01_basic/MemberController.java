package _01_basic;

import java.util.Random;

public class MemberController implements Controller {
	@Override
	public void execute() throws Exception {
		// 공통기능 - 실행시간 측정 출력
		long s = System.currentTimeMillis();
		
		// 핵심기능 - 등록과정
		Random r = new Random();
		for (int i = 0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}

		long e = System.currentTimeMillis();
		double time = (e - s) / 1000d;
		System.out.println("MemberController execute 메서드 실행시간 : " + time);		
	}
}
