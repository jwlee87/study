package day09;

public class Test01 {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("로뎅");
		d.setAge(8);
		
		Dog d2 = new Dog("로뎅", 8);
		
		System.out.println(
				d.getName() + "," + d.getAge());
		System.out.println(
				d2.getName() + "," + d2.getAge());
		
		
	}
}
