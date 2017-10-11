package day12.exam;

public class Triangle extends Shape {
	private int width, height;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void area() {
		System.out.printf("삼각형의 면적은 %d입니다.\n", width * height / 2);
	}
}
