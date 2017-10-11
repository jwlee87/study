import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coffee {
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<>();
		list.add("매");
		list.add("정");
		list.add("석");
		list.add("훈");
		list.add("연");
		list.add("희");
		list.add("주");
		list.add("화");
		list.add("현영");
		list.add("태영");
		list.add("우");
		list.add("전");
		list.add("재");
		list.add("진");
		list.add("원");
		for (int i = 1; i < 10; i++) {
			Collections.shuffle(list);
		}
		
		int count = 1;
		for (String name : list) {
			
			Thread.sleep(1000);
			System.out.print(name + ((count++ % 3 == 0) ? "\n" : "\t"));
		}
	} 
}











