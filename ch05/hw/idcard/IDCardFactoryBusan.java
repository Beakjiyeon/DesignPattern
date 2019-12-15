package ch05.hw.idcard;


import java.util.Vector;

//import ch05.hw.Singleton;
import ch05.hw.framework.Factory;
import ch05.hw.framework.Product;

// 백지연 : 5.3의 Singleton 패턴 기법 적용
// 백지연 : getInstance()구현시 3초가 걸리도록 한다. slowdown();
public class IDCardFactoryBusan extends Factory {
	private Vector names = new Vector();
	private static IDCardFactoryBusan singleton = null;
	
	public IDCardFactoryBusan(){
		System.out.println("인스턴스가 생성되었습니다.");
		slowdown();
	}

	//synchronized를 통해 동시에 두개 이상의 스레드가 getInstace() 안으로 들어오지 않게 한다.
	//이것을 통해 singlton패턴이 되지 않는 경우를 방지할 수 있다.
	synchronized public static IDCardFactoryBusan getInstance(){
		if(singleton == null){
			singleton = new IDCardFactoryBusan();//처음 싱글톤이 null인 상태로 만들어저 새로운 싱글톤이 생성되고 그것이 반환되는데 그 후 null값이
			//아니기 때문에 처음 만든 싱글 톤만이 반환된다. 
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
			// 백지연 : 3초 쉬게 한다.
			Thread.sleep(3000);// 1000/초 당
		}catch(InterruptedException e){
			
		}
	}

}
