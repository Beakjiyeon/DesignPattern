package ch19.hw;

//public class Main extends Thread {
public class Main {
	public static void main(String[] args) {
		// 백지연 : SafeFrame의 제목에 자신의 학번과 이름이 표시되도록 한다.
		SafeFrame frame = new SafeFrame("20171078 백지연");
		
		// 1초 간격으로 SafeFrame의 setClock( ) 메소드를 호출한다.
		while (true) {  // 무한루프
			// 백지연 : 최초시간을 15:00로 둔다. 
			// 백지연 : 15:00~24:00가 반복되도록 한다.
			for (int hour = 15; hour < 24; hour++) {
				frame.setClock(hour); // 금고의 시간을 설정한다.
				try {
					// 백지연 : 2초당 1시간이 흘러가게 한다.
					Thread.sleep(2000); // 2초간 쉰다.
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
