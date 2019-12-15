package ch01.hw;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("학번 : 20161042" + "이름 : 고유림");
		// TODO Auto-generated method stub
		//책 생성
		Book b1 = new Book("자료구조론", "박우창"); //b1이라는 Book의 객체 만듦
		Book b2  = new Book("소프트웨어분석설계", "최승훈");
		Book b3 = new Book("프로그래머수학", "이주영");
		Book b4 = new Book("컴퓨터작동원리", "유견아");
		Book b5 = new Book("컴퓨터그래픽스", "이경미");
		
		//책꽂이 생성
		BookShelf bs1 = new BookShelf(10);
		
		//책꽂기
		bs1.appendBook(b1);
		bs1.appendBook(b2);
		bs1.appendBook(b3);
		bs1.appendBook(b4);
		bs1.appendBook(b5);
		
		
		//책 한권씩 꺼내와서 제목 출력
		//책꽂이 에게 부탁해서 iterator 얻기
		Iterator it=bs1.iterator();
		
		//Iterator이용
		while(it.hasNext()){ // 책이 더있는지 검사
			Book b = (Book)it.next();
			System.out.println(b.getName()+" "+ b.getAuthor()); //있으면 꺼내오기
			                         //Object타입인데 getName은 Book타입이기 때문에 형변환을 해주어야 한다. it.next<Object> -> (Book)it.next()<Book>
									 // .이 우선 순위이기 때문에 (Book)it.next에 가로로 해주어야 한다.
		}
	}

}
