package _02_basic;

public class Test {
	public static void main(String[] args) {
		try {
			Controller controller = new BoardController();
			
			// 공통기능 - 실행시간 측정 출력
			long s = System.currentTimeMillis();	
			
			controller.execute();
			
			long e = System.currentTimeMillis();
			double time = (e - s) / 1000d;
			System.out.println("BoardController execute 메서드 실행시간 : " + time);
			
			controller = new MemberController();
			
			s = System.currentTimeMillis();
			
			controller.execute();
			
			e = System.currentTimeMillis();
			time = (e - s) / 1000d;
			System.out.println("MemberController execute 메서드 실행시간 : " + time);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
