package ch17.hw;
public class Main {
    public static void main(String[] args) {
    	// 백지연 : PrimeNumberGenerator의 인스턴스인 png 를 생성한다.
    	NumberGenerator png=new PrimeNumberGenerator();
    	
        // Observer observer1 = new DigitObserver();
        // Observer observer2 = new GraphObserver();
        // 백지연 : NamePrintObserver의 인스턴스를 생성한다.
        Observer observer3 = new NamePrintObserver();
        // 백지연 : GraphNmePrint를 추가 구현한 FrameObserver의 인스턴스를 생성한다.
        Observer observer4=new FrameObserver();
        
        
        // 백지연 : png에 모든 Observer를 등록한다.
        // png.addObserver(observer1);
        // png.addObserver(observer2);
        png.addObserver(observer3);
        png.addObserver(observer4);
        // 백지연 : png.execute()를 실행한다.
        png.execute();
        
       
        
    }
}
