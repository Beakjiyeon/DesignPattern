package ch11.hw;

public abstract class Entry {
	public abstract String getName(); // 이름을 얻는다.

	public abstract int getSize(); // 사이즈를 얻는다.

	// 백지연 : 메소드 추가. private 변수 getter
	public abstract String getDate();
	public abstract String getAuthor();
	// 백지연 : 파일의 개수를 얻는다.
	public abstract int getCount();
	public Entry add(Entry entry) throws FileTreatmentException {
		// 이 클래스에 다른 엔트리를 추가하려고 하면, 예외를 발생시킨다.
		// "자신이 처리하지 않고, 이 메소드를 호출한 객체로 전파시킨다"라고 선언되어 있음.
		throw new FileTreatmentException();
	}

	public void printList() { // 일람을 표시한다.
		printList("");
	}

	protected abstract void printList(String prefix); // prefix를 앞에 붙여서 일람을
														// 표시한다.

	// 백지연 : 생성날짜와 생성자, 파일개수까지 출력되게 한다.
	public String toString() { // 문자열 표현
		return getName() + " (" + getSize() + ")["+getDate()+"]["+getCount()+"개]["+getAuthor()+"]";
	}
}
