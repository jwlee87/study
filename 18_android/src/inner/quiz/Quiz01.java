package inner.quiz;
interface View {
	interface OnClickListener {
		public void onClick();
	}
}

class Button {
	public void setOnClickListener(View.OnClickListener click) {
		click.onClick();
	}
}
public class Quiz01 {
	public static void main(String[] args) {
		Button btn = new Button();
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("클릭됨..");
			}
		});
		/*
		View.OnClickListener click = new Click();
		btn.setOnClickListener(click);
		*/
	}	
}
class Click implements View.OnClickListener {
	@Override
	public void onClick() {
		System.out.println("클릭됨...");
	}
}


