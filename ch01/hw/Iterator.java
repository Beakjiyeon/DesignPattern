package ch01.hw;

// ��� Iterator�� ������ �� �޼ҵ带 ������ �������̽�
public interface Iterator {
	// ���Ұ� �� �ִ��� �˻��� �� ���Ǵ� �޼ҵ�
    public abstract boolean hasNext(); //�� ���� ������ ���Ұ� �ִ��� ������ ����� �޼ҵ�
    public abstract Object next(); // �� ���� ���Ҹ� �� �� ���Ǵ� �޼ҵ� 
    				//Ŭ���� �� - ŷ : �ֻ��� Ŭ�����̴�. -> ������ �������� �𸣱� ������ Object�� ����
}