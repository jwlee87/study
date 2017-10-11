
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
	public static final String hello_world = "�ȳ��ϼ���";
	public static final String title = "����Ŭ���� �׽�Ʈ��";	
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
		public static final String hello_world = "�ȳ��ϼ���";
		public static final String title = "����Ŭ���� �׽�Ʈ��";	
	}
}

// OGNL : Object Graphic Navigation Language
// �ڹ� ������Ƽ�� ���� ������ ������ �� ����ϴ� ����
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












