package ch03.hw;

public class Main {
	public static void main(String[] args) {
		// 백지연 : BeakJiYeonDisplay("백지연", "20171078", 2)객체 생성하기
		AbstractDisplay d = new BeakJiYeonDisplay("백지연", "20171078", 2);
		// 백지연 : d의 display() 메소드 호출하기
		d.display();
		
	}
}
