package ch01.hw;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("�й� : 20161042" + "�̸� : ������");
		// TODO Auto-generated method stub
		//å ����
		Book b1 = new Book("�ڷᱸ����", "�ڿ�â"); //b1�̶�� Book�� ��ü ����
		Book b2  = new Book("����Ʈ����м�����", "�ֽ���");
		Book b3 = new Book("���α׷��Ӽ���", "���ֿ�");
		Book b4 = new Book("��ǻ���۵�����", "���߾�");
		Book b5 = new Book("��ǻ�ͱ׷��Ƚ�", "�̰��");
		
		//å���� ����
		BookShelf bs1 = new BookShelf(10);
		
		//å�ȱ�
		bs1.appendBook(b1);
		bs1.appendBook(b2);
		bs1.appendBook(b3);
		bs1.appendBook(b4);
		bs1.appendBook(b5);
		
		
		//å �ѱǾ� �����ͼ� ���� ���
		//å���� ���� ��Ź�ؼ� iterator ���
		Iterator it=bs1.iterator();
		
		//Iterator�̿�
		while(it.hasNext()){ // å�� ���ִ��� �˻�
			Book b = (Book)it.next();
			System.out.println(b.getName()+" "+ b.getAuthor()); //������ ��������
			                         //ObjectŸ���ε� getName�� BookŸ���̱� ������ ����ȯ�� ���־�� �Ѵ�. it.next<Object> -> (Book)it.next()<Book>
									 // .�� �켱 �����̱� ������ (Book)it.next�� ���η� ���־�� �Ѵ�.
		}
	}

}
