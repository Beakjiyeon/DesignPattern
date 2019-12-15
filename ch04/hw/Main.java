package ch04.hw;

import ch04.hw.framework.*;
import ch04.hw.idcard.*;
import ch04.hw.tv.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("<< 20171078 백지연 >>");
    	
    	// 백지연 : 각각 다른 제품을 생산하지만 create, use메소드는 공통이다. 
    	
        Factory factory = new IDCardFactory();
        // 백지연 : IDCardFactory를 이용하여 최승훈, 자기이름 두 IDCard_New 제품 생산 
        Product card1 = factory.create("최승훈");
        Product card2 = factory.create("백지연");
        // 백지연 : use() 호출
        card1.use();
        card2.use();
        
        // 백지연 : tv공장 만들어서 tv 생산하기
        Factory factory2 =new TVFactory();
        Product tv1=factory2.create("20171078");
        Product tv2=factory2.create("777");
        Product tv3=factory2.create("888");
        Product tv4=factory2.create("999");
        // 백지연 : tv 사용하기
        tv1.use();
        tv2.use();
        tv3.use();
        tv4.use();
        
        // 백지연 : printAllModelNumbers()를 호출하여 모든 tv의 모델 번호 출력
        ((TVFactory) factory2).printAllModelNumbers();
        
    }
}
