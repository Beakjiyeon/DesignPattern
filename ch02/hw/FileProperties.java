package ch02.hw;

import java.io.*;
import java.util.Properties;

// Properties 클래스는, 이미 존재하는 클래스이다.
// FileProperties 클래스가 어댑터 역할을 한다.
public class FileProperties extends FileIO {
	private Properties property=new Properties(); // 백지연 : Properties 객체를 참조
	
    public void readFromFile(String filename) throws IOException {
        property.load(new FileInputStream(filename)); // 백지연 : 객체.메소드 형태로 바꿔준다.
    }
    public void writeToFile(String filename) throws IOException {
        property.store(new FileOutputStream(filename), "written by FileProperties"); // 백지연 : 객체.메소드 형태로 바꿔준다.
    }
    public void setValue(String key, String value) {
        property.setProperty(key, value); // 백지연 : 객체.메소드 형태로 바꿔준다.
    }
    public String getValue(String key) {
        return property.getProperty(key, ""); // 백지연 : 객체.메소드 형태로 바꿔준다.
    }
}

	
