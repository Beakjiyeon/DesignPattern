package ch02u.hw;
import java.io.*;
import java.util.Properties;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileIO f = (FileIO)new FileProperties();
        try {
            f.readFromFile("file.txt");//���� �ؽ�Ʈ ���� ���
            f.setValue("year", "2017");
            f.setValue("StudentId", "20161042");
            f.setValue("Name", "GoYuRim");
            f.setValue("HP", "010-4214-3453");
            f.writeToFile("properties.txt");//���ο� �ؽ�Ʈ ���� ���->���⿡ �����
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}

}
