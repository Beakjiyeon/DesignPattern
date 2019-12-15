package ch11.hw;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	private String name; // 디렉토리의 이름
	// 백지연 : 멤버변수 생성
	private String date; // 백지연 : 날짜
	private String author; // 백지연 : 생성자

	private Vector directory = new Vector(); // 디렉토리 엔트리의 집합
	// 백지연 : directory에는 이 디렉터리의 하위 폴더나 파일이 존재함.
	
	public Directory(String name) { // 생성자
		this.name = name;
	}
	// 백지연 : 메소드 추가1. 생성자
	Directory(String name, String date, String author){
		this.name=name;
		this.date=date;
		this.author=author;
	}
	


	public String getName() { // 이름을 얻는다.
		return name;
	}
	// 백지연 : private 멤버 변수에 대한 getter 메소드
	public String getDate() {
		return date;
	}
	public String getAuthor() {
		return author;
	}

	public int getSize() { // 사이즈를 얻는다.
		int size = 0;
		// 자신이 가지고 있는 모든 엔트리에 대해서, getSize( )호출하여 더한다.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			// entry는 Entry 타입으로 선언되어 있고,
			// Entry는 File이나 Directory의 부모 클래스이기 때문에 둘 다 참조할 수 있다.
			Entry entry = (Entry) it.next();
			// entry가 디렉토리인 경우에는, 다시 이 디렉토리의 getSize( )가 재귀적으로 호출된다. 
			size += entry.getSize(); 
			// => 그릇과 내용물이 동일시 된다.
		}
		return size;
	}
	// 백지연 : 메소드 추가2. 자기 아래 포함된 모든 파일의 개수를 리턴
	public int getCount() {
		// 백지연 : 파일개수를 담는 변수
		int count=0;
		// 백지연 : 자신이 가지고 있는 모든 엔트리에 대해서, getCount()를 호출하여 더한다.
		Iterator it=directory.iterator();
		// 백지연 : it는 디렉터리에 있는 내용물을 가리키는 것
		while(it.hasNext()) {
			Entry entry=(Entry)it.next();
			// 백지연 : 가리킬 내용물이 있다면, 다음 것을 가져온 뒤 Entry 타입으로 캐스팅한다.				// 백지연 : getCount 메소드는 디렉터리면 디렉터리인대로 파일이면 파일인대로 재귀적으로 개수를 호출한다.
			// 백지연 : 엔트리는 Entry 타입으로 선언되어 있고, 
			// 백지연 : Entry는 File과 Directory의 부모타입이므로 둘 다 참조할수 있다.
			count+=entry.getCount();
		}
		return count; // 파일 개수!!!
	}

	public Entry add(Entry entry) { // 엔트리의 추가
		// 입력인자로 들어온 Entry(File 또는 Directory 객체)를 벡터에 저장한다.
		directory.add(entry);
		return this;
	}

	protected void printList(String prefix) { // 엔트리의 일람
		System.out.println(prefix + "/" + this);
		// 자신이 가지고 있는 모든 엔트리에 대해서, printList( )호출한다.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			entry.printList(prefix + "/" + name);
		}
		
	}
}
