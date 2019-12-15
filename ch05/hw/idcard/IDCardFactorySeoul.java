package ch05.hw.idcard;

import java.util.Vector;

import ch05.hw.framework.Factory;
import ch05.hw.framework.Product;

// ������ : 5�� ������ ��������̿��� Singleton���� ����
public class IDCardFactorySeoul extends Factory{
	private Vector names = new Vector();
	
	// ������ : �̱����� �����Ѵ�.
	// ������ : �Ӽ����� �̸� �����ϴ� ���)�� �̿��Ͽ� Singleton ������ ������ Ŭ����

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
