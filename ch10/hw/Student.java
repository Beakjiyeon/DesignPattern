package ch10.hw;

public class Student implements Comparable{
	// ������ : �Ӽ��߰��ϱ�
	String name;
	String id;
	int height;
	// ������ : ������ �����
	public Student(String name,String id,int height) {
		this.name=name;
		this.id=id;
		this.height=height;
	}
	
	// ������ : Student ��ü�� height �Ӽ��� �̿��Ͽ� ũ�� ��. ��������
	public int compareTo(Object c) {
		
		if(this.height<((Student)c).getHeight()) {
			return 1;
		}
		
		else {
			return -1;
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}
	// ������ ; �л����� �̸�, �й�, Ű�� �б� ���� ��µ�.
	public String toString() {
		return "["+this.getName()+","+this.getId()+","+this.getHeight()+"]";
	}
	
	
	
	// ������ : �ʿ��� getter �޼ҵ� �߰��ϱ�
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public int getHeight() {
		return height;
	}
	

}
