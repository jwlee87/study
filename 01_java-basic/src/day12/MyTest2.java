package day12;

interface TV {
	void soundUp();

	void soundDown();
}

 class SonyTV implements TV{
	 public void soundUp(){
		 System.out.println("소니티비 소리 높인다.");
	 }
	 public void soundDown(){
		 System.out.println("소니티비 소리 내린다.");
	 }
 }

public class MyTest2 {
	public static void main(String[] args) {
		TV tv = new SonyTV();
		tv.soundUp();
		tv.soundDown();
	}
}
