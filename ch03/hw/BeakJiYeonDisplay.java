package ch03.hw;
//������ : [�̸�]Display Ŭ���� �߰��ϱ�
//������ : AbstractDisplay�� ���� Ŭ����
public class BeakJiYeonDisplay extends AbstractDisplay {
	// ������ : ��� ���� name, studentId, grade ����
	String name;
	String studentId;
	int grade;
	// ������ : �̸�, �й�, �г��� �Է� �޴� ������
	public BeakJiYeonDisplay(String name, String studentId, int grade){
		this.name=name;
		this.studentId=studentId;
		this.grade=grade;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	// ������ : open(): ��====================���� �� ���� �ٿ� ������ �а�(��:�������� ��ǻ���а�)�� ����ϴ� �޼ҵ�
	public void open() {
		System.out.println("====================");
		System.out.println("�������� ��ǻ���а�");
		
	}
	@Override
	// ������ : print(): �Ӽ��� �����ϰ� �ִ� �ڱ� �̸��� �й�, �г��� ����ϴ� �޼ҵ�
	public void print() {
		System.out.println("�й� "+studentId+" / "+grade+"�г� / "+name);
	}
	@Override
	// ������ : close(): �����ø� �޼ҵ� ���� �����Դϴ�.���� �� ���� �ٿ� ��====================�� ����ϴ� �޼ҵ�
	public void close() {
		System.out.println("���ø� �޼ҵ� ���� �����Դϴ�.");
		System.out.println("====================");
		
	}

}
