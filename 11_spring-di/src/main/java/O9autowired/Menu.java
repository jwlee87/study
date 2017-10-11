package O9autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Menu {
	
//	@Autowired
//	@Qualifier("hamham")
	private ISand sand;
	
	@Autowired
//	@Qualifier("hamham")
	public void setSand(ISand ham) {
		this.sand = ham;
		System.out.println("set 메서드 실행");
	}
	
//	@Autowired
	public Menu() {
		System.out.println("Menu 샌드위치 객체 생성자 호출");
	}
	
	public void print() {
		sand.info();
	}
}









