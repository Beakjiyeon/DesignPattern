package ch05.hw.idcard;

import java.util.Vector;

import ch05.hw.framework.Factory;
import ch05.hw.framework.Product;

// 백지연 : 5장 본문의 예제방식이용한 Singleton패턴 적용
public class IDCardFactorySeoul extends Factory{
	private Vector names = new Vector();
	
	// 백지연 : 싱글톤을 생성한다.
	// 백지연 : 속성에서 미리 생성하는 방식)을 이용하여 Singleton 패턴을 적용한 클래스

	private static IDCardFactorySeoul singleton = new IDCardFactorySeoul();
	
	public static IDCardFactorySeoul getInstance(){
		return singleton;
	}
	
	@Override
	protected Product createProduct(String name) {
		// TODO Auto-generated method stub
		return new IDCard(name);
	}

	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		names.add(((IDCard)product));
	}
	
	protected Vector getNames(){
		return names;
	}
	
}
