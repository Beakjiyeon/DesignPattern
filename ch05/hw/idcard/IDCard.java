package ch05.hw.idcard;

import ch05.hw.framework.Product;

public class IDCard extends Product{
	private String name;

    // private�̳� public ���� ����Ǿ� ���� ������, 
    // ���� ��Ű���� ���� Ŭ�����鸸�� �� �����ڸ� ȣ���� �� �ִ�.
    public IDCard(String name) {
        System.out.println(name + "�� ī�带 ����ϴ�.");
        this.name = name;
    }
    public void use() {
        System.out.println(name + "�� ī�带 ����մϴ�.");
    }
    public String getOwner() {
        return name;
    }
}
