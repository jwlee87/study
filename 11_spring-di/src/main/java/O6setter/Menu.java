package O6setter;

public class Menu {
	public Menu() {
		System.out.println("Menu 매개변수 없는 생성자");
	}
	
	private String desc;
	public void setDesc(String desc) {
		this.desc = desc;
		System.out.println("Menu 문자열 set 메서드 호출");
	}
	private ISand sand;
	public void setSand(ISand sand) {
		this.sand = sand;
		System.out.println("Menu 샌드위치 객체 set 메서드 호출");
	}
	
	public void print() {
		System.out.println("desc : " + desc);
	}
}









