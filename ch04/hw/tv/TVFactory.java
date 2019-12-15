package ch04.hw.tv;

import java.util.Iterator;
import java.util.Vector;


import ch04.hw.framework.*;

public class TVFactory extends Factory {
	// 백지연 : 생산된 제품들의 모델번호들을 저장하는 변수
	Vector modelNos=new Vector();
	// 백지연 : 시리얼 번호 속성
	
	
	// 백지연 : 입력된 모델 번호의 tv를 생성해서 반환하는 메소드
	public Product createProduct(String model) {
		return new TV(model);
		
	}
	// 백지연 : 입력자인 product의 모델번호를 modelNos에 추가한다.
	public void registerProduct(Product product) {
		modelNos.add(((TV)product).getModelNo());
	}
	// 백지연 : modelNos에 저장되어 있는 모델 번호들을 하나씩 끄집어내 와서 출력한다.
	public void printAllModelNumbers() {
		Iterator it=modelNos.iterator();
		while(it.hasNext()) {
			String num=(String)it.next();
			System.out.println(num);
		}
	}
	

}
