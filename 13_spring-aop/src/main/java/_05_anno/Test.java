package _05_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"anno/test.xml"
			);
			
			Controller controller = (Controller)context.getBean("board");
			controller.execute();
			
			controller = (Controller)context.getBean("member");
			controller.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









