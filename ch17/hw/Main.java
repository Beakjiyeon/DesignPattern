package ch17.hw;
public class Main {
    public static void main(String[] args) {
    	// ������ : PrimeNumberGenerator�� �ν��Ͻ��� png �� �����Ѵ�.
    	NumberGenerator png=new PrimeNumberGenerator();
    	
        // Observer observer1 = new DigitObserver();
        // Observer observer2 = new GraphObserver();
        // ������ : NamePrintObserver�� �ν��Ͻ��� �����Ѵ�.
        Observer observer3 = new NamePrintObserver();
        // ������ : GraphNmePrint�� �߰� ������ FrameObserver�� �ν��Ͻ��� �����Ѵ�.
        Observer observer4=new FrameObserver();
        
        
        // ������ : png�� ��� Observer�� ����Ѵ�.
        // png.addObserver(observer1);
        // png.addObserver(observer2);
        png.addObserver(observer3);
        png.addObserver(observer4);
        // ������ : png.execute()�� �����Ѵ�.
        png.execute();
        
       
        
    }
}
