package _04_schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"schema/test.xml"
			);
			
			Controller controller = (BoardController)context.getBean("board");
			controller.execute();
			
			controller = (MemberController)context.getBean("member");
			controller.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









