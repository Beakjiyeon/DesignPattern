package ch17.hw;
// 백지연 : 관찰자 클래스1
public class NamePrintObserver implements Observer{
	public void update(NumberGenerator generator) {
		// 백지연 : 관찰 대상자로부터 숫자를 얻기
		int num=generator.getNumber();
		System.out.print("NamePrintObserver: ");
		for(int i=0;i<num;i++) {
			System.out.print("백지연 ");
		}
		System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
	}
}
