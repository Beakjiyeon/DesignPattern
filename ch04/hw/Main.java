package ch04.hw;

import ch04.hw.framework.*;
import ch04.hw.idcard.*;
import ch04.hw.tv.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("<< 20171078 ������ >>");
    	
    	// ������ : ���� �ٸ� ��ǰ�� ���������� create, use�޼ҵ�� �����̴�. 
    	
        Factory factory = new IDCardFactory();
        // ������ : IDCardFactory�� �̿��Ͽ� �ֽ���, �ڱ��̸� �� IDCard_New ��ǰ ���� 
        Product card1 = factory.create("�ֽ���");
        Product card2 = factory.create("������");
        // ������ : use() ȣ��
        card1.use();
        card2.use();
        
        // ������ : tv���� ���� tv �����ϱ�
        Factory factory2 =new TVFactory();
        Product tv1=factory2.create("20171078");
        Product tv2=factory2.create("777");
        Product tv3=factory2.create("888");
        Product tv4=factory2.create("999");
        // ������ : tv ����ϱ�
        tv1.use();
        tv2.use();
        tv3.use();
        tv4.use();
        
        // ������ : printAllModelNumbers()�� ȣ���Ͽ� ��� tv�� �� ��ȣ ���
        ((TVFactory) factory2).printAllModelNumbers();
        
    }
}
