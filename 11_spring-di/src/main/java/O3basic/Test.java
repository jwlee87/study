package O3basic;

// 사용자
public class Test {
	public static void main(String[] args) {
		 TvFactory factory = new TvFactory();
		 Tv tv = factory.getBean("sony");
		 tv.powerOn();
		 tv.powerOff();

		 tv = factory.getBean("lg");
		 tv.powerOn();
		 tv.powerOff();
	}
}
