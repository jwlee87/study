package day06.quiz;
class Bread {
	int totalPrice;
	String name;
	int price;
}

public class Quiz02 {
	public static void main(String[] args) {
		Bread b1 = new Bread();
		Bread b2 = new Bread();
		
		b1.name = "소보르";
		b1.price = 1000;

		b2.name = "단팥빵";
		b2.price = 1500;
		
		Bread[] arr = new Bread[2];
		arr[0] = b1;
		arr[1] = b2;
		
		arr[0].name = "바게트";
		Bread b3 = arr[1];
		b3.price = 3000;
		
		System.out.println(b1.name + " " + b1.price);
		System.out.println(b2.name + " " + b2.price);
	}
}










