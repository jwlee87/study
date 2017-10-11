package day12.exam;

public class Rectangle extends Shape {
	protected int side1, side2;
	public Rectangle(int side1, int side2) {
		this.side1 = side1;
		this.side2 = side2;
	}
	
	@Override
	public void area() {
		// 도형의 면적을 구하고 출력
		System.out.printf("직사각형의 면적은 %d입니다.\n", side1 * side2);
	}
}
