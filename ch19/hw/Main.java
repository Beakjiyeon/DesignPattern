package ch19.hw;

//public class Main extends Thread {
public class Main {
	public static void main(String[] args) {
		// ������ : SafeFrame�� ���� �ڽ��� �й��� �̸��� ǥ�õǵ��� �Ѵ�.
		SafeFrame frame = new SafeFrame("20171078 ������");
		
		// 1�� �������� SafeFrame�� setClock( ) �޼ҵ带 ȣ���Ѵ�.
		while (true) {  // ���ѷ���
			// ������ : ���ʽð��� 15:00�� �д�. 
			// ������ : 15:00~24:00�� �ݺ��ǵ��� �Ѵ�.
			for (int hour = 15; hour < 24; hour++) {
				frame.setClock(hour); // �ݰ��� �ð��� �����Ѵ�.
				try {
					// ������ : 2�ʴ� 1�ð��� �귯���� �Ѵ�.
					Thread.sleep(2000); // 2�ʰ� ����.
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
