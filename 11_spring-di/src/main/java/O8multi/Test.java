package O8multi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext(
//				new String[] {"multi/test.xml", "multi/test1.xml"}
				"multi/test2.xml"
		); 
	}
}