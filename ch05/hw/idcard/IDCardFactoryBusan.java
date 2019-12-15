package ch05.hw.idcard;


import java.util.Vector;

//import ch05.hw.Singleton;
import ch05.hw.framework.Factory;
import ch05.hw.framework.Product;

// ������ : 5.3�� Singleton ���� ��� ����
// ������ : getInstance()������ 3�ʰ� �ɸ����� �Ѵ�. slowdown();
public class IDCardFactoryBusan extends Factory {
	private Vector names = new Vector();
	private static IDCardFactoryBusan singleton = null;
	
	public IDCardFactoryBusan(){
		System.out.println("�ν��Ͻ��� �����Ǿ����ϴ�.");
		slowdown();
	}

	//synchronized�� ���� ���ÿ� �ΰ� �̻��� �����尡 getInstace() ������ ������ �ʰ� �Ѵ�.
	//�̰��� ���� singlton������ ���� �ʴ� ��츦 ������ �� �ִ�.
	synchronized public static IDCardFactoryBusan getInstance(){
		if(singleton == null){
			singleton = new IDCardFactoryBusan();//ó�� �̱����� null�� ���·� ������� ���ο� �̱����� �����ǰ� �װ��� ��ȯ�Ǵµ� �� �� null����
			//�ƴϱ� ������ ó�� ���� �̱� �游�� ��ȯ�ȴ�. 
		}
		return singleton;
	}
	@Override
	protected Product createProduct(String owner) {
		// TODO Auto-generated method stub
		return new IDCard(owner);
	}

	@Override
	protected void registerProduct(Product product) {
		IDCard card = (IDCard)product;
		names.add(card.getOwner());
	}
	
	private void slowdown(){
		try{
			// ������ : 3�� ���� �Ѵ�.
			Thread.sleep(3000);// 1000/�� ��
		}catch(InterruptedException e){
			
		}
	}

}
