package inner;

class Layout {
	public static final int main_layout = 1;
	public static final int sub_layout = 2;
}
class Drawable {
	public static final String icon16x16 = "a.png";
	public static final String icon64x64 = "b.png";
	public static final String icon128x128 = "c.png";
}
class Label {
	public static final String hello_world = "안녕하세요";
	public static final String title = "내부클래스 테스트중";	
}
class ResourceX {
	static Layout layout;
	static Drawable drawable;
	static Label label;
}

class Resource {
	public static class layout {
		public static final int main_layout = 1;
		public static final int sub_layout = 2;
	}
	public static class drawable {
		public static final String icon16x16 = "a.png";
		public static final String icon64x64 = "b.png";
		public static final String icon128x128 = "c.png";
	}
	public static class label {
		public static final String hello_world = "안녕하세요";
		public static final String title = "내부클래스 테스트중";	
	}
}

// OGNL : Object Graphic Navigation Language
// 자바 프로퍼티의 값을 꺼내고 설정할 때 사용하는 문법
public class OGNLTest {
	public static void main(String[] args) {
		System.out.println(Resource.layout.main_layout);
		System.out.println(Resource.drawable.icon16x16);
		System.out.println(Resource.label.hello_world);
//		System.out.println(ResourceX.layout.main_layout);
//		System.out.println(ResourceX.drawable.icon16x16);
//		System.out.println(ResourceX.label.hello_world);
	}
}
























