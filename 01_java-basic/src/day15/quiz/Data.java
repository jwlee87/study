package day15.quiz;

public class Data implements Comparable<Data> {
	private int num;
	public Data(int num) {
		this.num = num;
	}
	public int getNum() { return num; }
	public String toString() { return String.valueOf(num); }
	
	@Override
	public int compareTo(Data o) {
		// 0이면 자리바꿈 없음, 
		// 양수이면 비교대상보다 뒤로이동, 
		// 음수이면 비교대상보다 앞으로 이동
		if (this.num == o.getNum()) return 0;
		return this.num < o.getNum() ? -1 : 1;
	}
	
}
