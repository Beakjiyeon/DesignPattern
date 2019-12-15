package ch17.hw;
import java.util.Random;

//���� ��� Ŭ����
public class PrimeNumberGenerator extends NumberGenerator{
	private Random random = new Random();
	private int number;
	
	public int getNumber() {
		return number;
	}

	//1~100������ ���� �߻�
	//�Ҽ��̸� true �����ڿ��� ����
	public void execute() {
		for(int i = 0; i<100; i++)
		{
			number = random.nextInt(100)+1;
			if(isPrimeNumber(number)){
				notifyObservers();
				try {
	    			Thread.sleep(1500);
	    		} catch (InterruptedException e) {
	    		}
			}
		}
		
	}

	private boolean isPrimeNumber(int num) {
		int i;
		if(num==1){
			return false;
		}
		for(i = 2; i<num; i++){
			if(num%i == 0){
				break;
			} 
		}
		if(i<num)
			return false;
		else
			return true;
	}

}
