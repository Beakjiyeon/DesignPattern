package ch11.hw;

public class Main {
	public static void main(String[] args) {
		try {
			// 백지연 : 학번, 이름 출력
			System.out.println("20171078 백지연");
			
			// 백지연 : 디렉터리 생성
			Directory MyDocuments = new Directory("MyDocuments","20180901","BeakJiyeon");
			Directory MyData = new Directory("Mydata","20180901","BeakJiyeon");
			Directory MyPictures = new Directory("MyPictures","20180901","BeakJiyeon");
		
			MyDocuments.add(new File("백지연0.doc","20181001",1000,"BeakJiyeon"));
			MyDocuments.add(MyData);
			MyData.add(new File("백지연1.doc","20181001",1500,"BeakJiyeon"));
			MyData.add(new File("백지연2.doc","20181001",2000,"BeakJiyeon"));
			MyData.add(MyPictures);
			MyPictures.add(new File("백지연3.gif","20181101",2500,"BeakJiyeon"));
			MyPictures.add(new File("백지연4.jpg","20181101",3000,"BeakJiyeon"));
			MyPictures.add(new File("백지연5.png","20181101",3500,"BeakJiyeon"));
			
			
			MyDocuments.printList();

		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
