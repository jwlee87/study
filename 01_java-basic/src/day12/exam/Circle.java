package day12.exam;

public class Circle extends Shape {

	private int radius;
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public void area() {
		System.out.printf("원의 면적은 %.2f입니다.\n", radius * radius * Math.PI);
	}
}
