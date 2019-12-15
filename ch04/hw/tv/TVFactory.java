package ch04.hw.tv;

import java.util.Iterator;
import java.util.Vector;


import ch04.hw.framework.*;

public class TVFactory extends Factory {
	// ������ : ����� ��ǰ���� �𵨹�ȣ���� �����ϴ� ����
	Vector modelNos=new Vector();
	// ������ : �ø��� ��ȣ �Ӽ�
	
	
	// ������ : �Էµ� �� ��ȣ�� tv�� �����ؼ� ��ȯ�ϴ� �޼ҵ�
	public Product createProduct(String model) {
		return new TV(model);
		
	}
	// ������ : �Է����� product�� �𵨹�ȣ�� modelNos�� �߰��Ѵ�.
	public void registerProduct(Product product) {
		modelNos.add(((TV)product).getModelNo());
	}
	// ������ : modelNos�� ����Ǿ� �ִ� �� ��ȣ���� �ϳ��� ����� �ͼ� ����Ѵ�.
	public void printAllModelNumbers() {
		Iterator it=modelNos.iterator();
		while(it.hasNext()) {
			String num=(String)it.next();
			System.out.println(num);
		}
	}
	

}
