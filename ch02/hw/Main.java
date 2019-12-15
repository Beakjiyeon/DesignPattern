package ch02.hw;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        FileIO f = (FileIO) new FileProperties();
        try {
        	f .readFromFile("file.txt");
            f.setValue("Year", "2018"); // 백지연 : Year=2018 
            f.setValue("bornYear", "1998"); // 백지연 : bornYear=자기가태어난년도 
            f.setValue("StudentId", "20171078"); // 백지연 : StudentId=자기학번
            f.setValue("Name", "Beak Jiyeon"); // 백지연 : Name=자기이름(영어로 작성)
            f.setValue("Location", "Seoul"); // 백지연 : Location=자기태어난도시(영어로작성) 
            f.writeToFile("new-properties36.txt");
   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}