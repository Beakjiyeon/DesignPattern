package ch02.hw;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        FileIO f = (FileIO) new FileProperties();
        try {
        	f .readFromFile("file.txt");
            f.setValue("Year", "2018"); // ������ : Year=2018 
            f.setValue("bornYear", "1998"); // ������ : bornYear=�ڱⰡ�¾�⵵ 
            f.setValue("StudentId", "20171078"); // ������ : StudentId=�ڱ��й�
            f.setValue("Name", "Beak Jiyeon"); // ������ : Name=�ڱ��̸�(����� �ۼ�)
            f.setValue("Location", "Seoul"); // ������ : Location=�ڱ��¾����(������ۼ�) 
            f.writeToFile("new-properties36.txt");
   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}