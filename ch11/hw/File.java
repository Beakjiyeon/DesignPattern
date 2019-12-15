package ch11.hw;

public class File extends Entry {
	private String name;
	private int size;
	
	// ������ : ������� ����
	private String date; // ������ : ��¥
	private String author; // ������ : ������
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	// ������ : �޼ҵ� �߰�1. ������
	public File(String name, String date, int size, String author) {
		this.name=name;
		this.date=date;
		this.size=size;
		this.author=author;
	}

	// ������ : �޼ҵ� �߰�2. ����Ŭ�����̹Ƿ� 1 ����
	public int getCount() {
		return 1;
	}
	
	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}
	// ������ : �޼ҵ� �߰�. private�� ���� getter�޼ҵ�
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
