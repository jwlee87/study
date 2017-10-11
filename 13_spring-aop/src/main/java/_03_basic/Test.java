package _03_basic;

public class Test {
	public static void main(String[] args) {
		try {
			
			ProxyController controller = new ProxyController(new BoardController());
			controller.execute();
			
			controller = new ProxyController(new MemberController());
			controller.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
