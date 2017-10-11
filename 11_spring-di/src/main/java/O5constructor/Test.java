package O5constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext(
				"constructor/test.xml"
		); 
		
		Menu menu1 = (Menu)container.getBean("menu1");
		menu1.print();
		
		Menu menu2 = (Menu)container.getBean("menu2");
		menu2.print();
		
	}
}
