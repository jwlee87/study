package day12.exam;

public class Square extends Rectangle {
	public Square(int side) {
		super(side, side);
	}
	public void area() {
		System.out.printf("정사각형의 면적은 %d입니다.\n", side1 * side2);
	}
}
