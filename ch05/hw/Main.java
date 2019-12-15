package ch05.hw;

import ch05.hw.framework.*;

import ch05.hw.idcard.*;

// 백지연 : Thread 클래스를 상속받아서, Main 클래스 자신이 스레드가 된다.
public class Main extends Thread {

	public static void main(String[] args) {
		
		// 백지연 : IDCardFactorySeoul의 getInstance()를 두번 호출
		// 백지연 : factory1과 factory2가 가리키도록 한다.
		// 백지연 : 이 두 변수가 동일한 객체를 가리키는지 테스트한다.
		// 백지연 : 출력 메세지: "factory1과 factory2는 같은 인스턴스 입니다."
		Factory factory1 = IDCardFactorySeoul.getInstance();
		Factory factory2 = IDCardFactorySeoul.getInstance();
		
		if(factory1 == factory2){
			System.out.println("factory01과 factory02는 같은 인스턴스 입니다.");
		}
		else
			System.out.println("factory01과 factory02는 다른 인스턴스 입니다.");

		// 백지연 : Main의 객체 3개 생성, (이름은, "최승훈","자기이름1","자기이름2")
		// 백지연 : 각각의 start메소드를 호출
		// 백지연 : run메소드 - IDCardFactoryBusan 인스턴스 얻고 자신의 이름 getName()이용하여 얻어 주소와 출력
		
		// 백지연 : 스레드 3개를 생성한 후 실행시킨다.
		new Main("최승훈").start(); // 백지연 : run( ) 이 자동으로 실행된다.
		new Main("백지연").start();
		new Main("백지연2").start();
		
	}
	public void run(){
		IDCardFactoryBusan obj = IDCardFactoryBusan.getInstance();
		// 백지연 : 생성된 객체의 주소값을 저장한다.
		System.out.println(getName() + ": obj = " + obj);
		// 백지연 : Main에 넣은 문자를 얻어옴.
	}
	public Main(String name){
		super(name);//인자없는 생성자를 먼저 부른다.
	}

}
