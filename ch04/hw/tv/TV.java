package ch04.hw.tv;

import ch04.hw.framework.*;

public class TV extends Product{
	private String modelNo; // ������ : �� ��ȣ �Ӽ� �߰�
	
	// ������ : �� ��ȣ�� �Ӽ��� �����ϴ� �޼ҵ� : ������
	public TV(String modelNo) {
		this.modelNo=modelNo;
	}
	// ������ : �� ��ȣ ??? �� tv�� ����Ѵٴ� �޼����� ����ϴ� �޼ҵ�
	public void use() {
		System.out.println("�𵨹�ȣ "+modelNo+"�� TV�� ����մϴ�.");
	}
	// ������ : �ڽ��� �� ��ȣ�� ��ȯ�ϴ� �޼ҵ�
	public String getModelNo() {
		return modelNo;
	}

}
