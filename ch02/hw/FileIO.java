package ch02.hw;
import java.util.Properties;
import java.io.*;


// Main(client)가 필요로하는 메소드
public abstract class FileIO{ // 백지연 : interface에서 추상 class로 바꾸었다.
    public void readFromFile(String filename) throws IOException{};
    public void writeToFile(String filename) throws IOException{};
    public void setValue(String key, String value) {};
    public String getValue(String key) {return key;};
}
