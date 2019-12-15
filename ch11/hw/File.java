package ch11.hw;

public class File extends Entry {
	private String name;
	private int size;
	
	// 백지연 : 멤버변수 생성
	private String date; // 백지연 : 날짜
	private String author; // 백지연 : 생성자
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	// 백지연 : 메소드 추가1. 생성자
	public File(String name, String date, int size, String author) {
		this.name=name;
		this.date=date;
		this.size=size;
		this.author=author;
	}

	// 백지연 : 메소드 추가2. 파일클래스이므로 1 리턴
	public int getCount() {
		return 1;
	}
	
	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}
	// 백지연 : 메소드 추가. private형 변수 getter메소드
	public String getDate() {
		return date;
	}
	public String getAuthor() {
		return author;
	}
	
	
	protected void printList(String prefix) {
		System.out.println(prefix + "/" +this);
	}
}
