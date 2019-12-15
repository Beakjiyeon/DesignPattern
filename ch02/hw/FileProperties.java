package ch02.hw;

import java.io.*;
import java.util.Properties;

// Properties Ŭ������, �̹� �����ϴ� Ŭ�����̴�.
// FileProperties Ŭ������ ����� ������ �Ѵ�.
public class FileProperties extends FileIO {
	private Properties property=new Properties(); // ������ : Properties ��ü�� ����
	
    public void readFromFile(String filename) throws IOException {
        property.load(new FileInputStream(filename)); // ������ : ��ü.�޼ҵ� ���·� �ٲ��ش�.
    }
    public void writeToFile(String filename) throws IOException {
        property.store(new FileOutputStream(filename), "written by FileProperties"); // ������ : ��ü.�޼ҵ� ���·� �ٲ��ش�.
    }
    public void setValue(String key, String value) {
        property.setProperty(key, value); // ������ : ��ü.�޼ҵ� ���·� �ٲ��ش�.
    }
    public String getValue(String key) {
        return property.getProperty(key, ""); // ������ : ��ü.�޼ҵ� ���·� �ٲ��ش�.
    }
}

	
