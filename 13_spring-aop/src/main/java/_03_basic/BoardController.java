package _03_basic;

import java.util.Random;

public class BoardController implements Controller{
	public void execute() throws Exception {
		// 핵심기능 - 등록과정
		Random r = new Random();
		for (int i = 0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
	}
}