package ch11.hw;

public class Main {
	public static void main(String[] args) {
		try {
			// ������ : �й�, �̸� ���
			System.out.println("20171078 ������");
			
			// ������ : ���͸� ����
			Directory MyDocuments = new Directory("MyDocuments","20180901","BeakJiyeon");
			Directory MyData = new Directory("Mydata","20180901","BeakJiyeon");
			Directory MyPictures = new Directory("MyPictures","20180901","BeakJiyeon");
		
			MyDocuments.add(new File("������0.doc","20181001",1000,"BeakJiyeon"));
			MyDocuments.add(MyData);
			MyData.add(new File("������1.doc","20181001",1500,"BeakJiyeon"));
			MyData.add(new File("������2.doc","20181001",2000,"BeakJiyeon"));
			MyData.add(MyPictures);
			MyPictures.add(new File("������3.gif","20181101",2500,"BeakJiyeon"));
			MyPictures.add(new File("������4.jpg","20181101",3000,"BeakJiyeon"));
			MyPictures.add(new File("������5.png","20181101",3500,"BeakJiyeon"));
			
			
			MyDocuments.printList();

		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
