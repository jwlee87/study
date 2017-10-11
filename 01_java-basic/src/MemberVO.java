
public class MemberVO {
	public static void main(String[] args) {
		MemberVO member = new MemberVO();
		member.setId("aa").setName("aaa");
	}
	
	
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
}












