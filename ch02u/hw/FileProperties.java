package ch02u.hw;

import java.io.*;
import java.util.Properties;

//����� ����
public class FileProperties implements FileIO {
	
	private Properties pro = new Properties();
	
	@Override
	public void readFromFile(String filename) throws IOException {//���� �� ��Ʈ�� ����
		// TODO Auto-generated method stub
		pro.load(new FileInputStream(filename));
	}

	@Override
	public void writeToFile(String filename) throws IOException {//���Ͽ� ����
		// TODO Auto-generated method stub
		pro.store(new FileOutputStream(filename), "written by FileProperties");
	}

	@Override
	public void setValue(String key, String value) {//���Ͽ� �ֱ�
		// TODO Auto-generated method stub
		pro.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {//Ű������ ����� ��������
		// TODO Auto-generated method stub
		return pro.getProperty(key, "");
	}
	
}
