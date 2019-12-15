package ch02u.hw;

import java.io.*;
import java.util.Properties;

//어댑터 역할
public class FileProperties implements FileIO {
	
	private Properties pro = new Properties();
	
	@Override
	public void readFromFile(String filename) throws IOException {//파일 인 스트림 열기
		// TODO Auto-generated method stub
		pro.load(new FileInputStream(filename));
	}

	@Override
	public void writeToFile(String filename) throws IOException {//파일에 저장
		// TODO Auto-generated method stub
		pro.store(new FileOutputStream(filename), "written by FileProperties");
	}

	@Override
	public void setValue(String key, String value) {//파일에 넣기
		// TODO Auto-generated method stub
		pro.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {//키값으로 밸류값 가져오기
		// TODO Auto-generated method stub
		return pro.getProperty(key, "");
	}
	
}
