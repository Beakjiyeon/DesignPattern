package ch17.hw;
// ������ : ������ Ŭ����1
public class NamePrintObserver implements Observer{
	public void update(NumberGenerator generator) {
		// ������ : ���� ����ڷκ��� ���ڸ� ���
		int num=generator.getNumber();
		System.out.print("NamePrintObserver: ");
		for(int i=0;i<num;i++) {
			System.out.print("������ ");
		}
		System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
	}
}
