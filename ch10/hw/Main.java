package ch10.hw;

import ch10.hw.InsertSorter;
import ch10.hw.SortAndPrint;
// ������ : �ð� ������ ���� import
import java.util.Date;

public class Main {
    public static void main(String[] args) {
    	
    	
    	// ������ : ���� Ÿ�� �����ϱ�
    	// ������ : data �迭�� �� �����ϱ� ���� �� 5��.
    	Student s1=new Student("������","20171078",163);
    	Student s2=new Student("������","20171034",183);
    	Student s3=new Student("�����","20171045",173);
    	Student s4=new Student("������","20171010",100);
    	Student s5=new Student("������","20171000",130);		
        Student[] data = {s1,s2,s3,s4,s5};
        
        long start;
        long end;
        
        Date date = new Date();
       
        
        SortAndPrint sap;
        
        // ������ : �μ�Ʈ ��Ʈ�� �����ϱ�
        System.out.println("\nby InsertSort >>>");
        start=date.getTime();
        sap = new SortAndPrint(data, new InsertSorter());
        sap.execute();
        end=date.getTime();
        // ������ : ����ð� ����
        System.out.println("����ð� :"+(end-start)/1000.0+"ms");
        
        // ������ : �����͸� �����ϱ� ������ �ٲٱ�
        data[0]=s1;
        data[1]=s2;
        data[2]=s3;
        data[3]=s4;
        data[4]=s5;
        
        // ������ : ����Ʈ�� �����ϱ�
        System.out.println("\nby QuicktSort >>>");
        start= date.getTime();
        sap = new SortAndPrint(data, new QuickSorter());
        sap.execute();
        end= date.getTime();
        // ������ : ����ð� ����
        System.out.println("����ð� :"+(end-start)/1000.0+"ms");
        
        // ������ : �����͸� �����ϱ� ������ �ٲٱ�
        data[0]=s1;
        data[1]=s2;
        data[2]=s3;
        data[3]=s4;
        data[4]=s5;
        
        // ������ : �����Ʈ�� �����ϱ�
        System.out.println("\nby BubbleSort >>>");
        start= date.getTime();
        sap = new SortAndPrint(data, new BubbleSorter());
        sap.execute();
        end= date.getTime();
        // ������ : ����ð� ����
        System.out.println("����ð� :"+(end-start)/1000.0+"ms");
        
    }
}
