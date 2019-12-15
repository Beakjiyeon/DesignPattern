package ch10.hw;

public class Student implements Comparable{
	// 백지연 : 속성추가하기
	String name;
	String id;
	int height;
	// 백지연 : 생성자 만들기
	public Student(String name,String id,int height) {
		this.name=name;
		this.id=id;
		this.height=height;
	}
	
	// 백지연 : Student 객체의 height 속성을 이용하여 크기 비교. 내림차순
	public int compareTo(Object c) {
		
		if(this.height<((Student)c).getHeight()) {
			return 1;
		}
		
		else {
			return -1;
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}
	// 백지연 ; 학생들의 이름, 학번, 키가 읽기 좋게 출력됨.
	public String toString() {
		return "["+this.getName()+","+this.getId()+","+this.getHeight()+"]";
	}
	
	
	
	// 백지연 : 필요한 getter 메소드 추가하기
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
