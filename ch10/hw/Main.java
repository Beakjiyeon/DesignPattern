package ch10.hw;

import ch10.hw.InsertSorter;
import ch10.hw.SortAndPrint;
// 백지연 : 시간 측정을 위해 import
import java.util.Date;

public class Main {
    public static void main(String[] args) {
    	
    	
    	// 백지연 : 원소 타입 변경하기
    	// 백지연 : data 배열의 값 변경하기 원소 총 5개.
    	Student s1=new Student("백지연","20171078",163);
    	Student s2=new Student("유혁상","20171034",183);
    	Student s3=new Student("김원소","20171045",173);
    	Student s4=new Student("김윤형","20171010",100);
    	Student s5=new Student("백져니","20171000",130);		
        Student[] data = {s1,s2,s3,s4,s5};
        
        long start;
        long end;
        
        Date date = new Date();
       
        
        SortAndPrint sap;
        
        // 백지연 : 인서트 소트로 정렬하기
        System.out.println("\nby InsertSort >>>");
        start=date.getTime();
        sap = new SortAndPrint(data, new InsertSorter());
        sap.execute();
        end=date.getTime();
        // 백지연 : 실행시간 측정
        System.out.println("실행시간 :"+(end-start)/1000.0+"ms");
        
        // 백지연 : 데이터를 정렬하기 전으로 바꾸기
        data[0]=s1;
        data[1]=s2;
        data[2]=s3;
        data[3]=s4;
        data[4]=s5;
        
        // 백지연 : 퀵소트로 정렬하기
        System.out.println("\nby QuicktSort >>>");
        start= date.getTime();
        sap = new SortAndPrint(data, new QuickSorter());
        sap.execute();
        end= date.getTime();
        // 백지연 : 실행시간 측정
        System.out.println("실행시간 :"+(end-start)/1000.0+"ms");
        
        // 백지연 : 데이터를 정렬하기 전으로 바꾸기
        data[0]=s1;
        data[1]=s2;
        data[2]=s3;
        data[3]=s4;
        data[4]=s5;
        
        // 백지연 : 버블소트로 정렬하기
        System.out.println("\nby BubbleSort >>>");
        start= date.getTime();
        sap = new SortAndPrint(data, new BubbleSorter());
        sap.execute();
        end= date.getTime();
        // 백지연 : 실행시간 측정
        System.out.println("실행시간 :"+(end-start)/1000.0+"ms");
        
    }
}
