package ch20.hw;

import java.util.Hashtable;

// BigChar의 인스턴스를 작성하는 공장
// 여기서 인스턴스의 공유가 실현된다.
public class BigCharFactory {
	// 이미 만들어진 BigChar의 인스턴스를 모아서 관리한다.
	private Hashtable pool = new Hashtable();

	// Singleton 패턴을 사용함.
	private static BigCharFactory singleton = new BigCharFactory();

	// 생성자는 private
	private BigCharFactory() {
	}

	// 유일한 하나의 인스턴스를 얻는다.
	public static BigCharFactory getInstance() {
		return singleton;
	}

	// Flyweight 패턴의 중심이 되는 메소드
	// 인수로 제공된 문자에 대응하는 BigChar 인스턴스를 만든다
	public synchronized BigChar getBigChar(char charname) { // 백지연 : 만약 charname이 3이라면
		// 백지연 : pool에 가서 먼저 검색을 한다. pool.getKey()
		BigChar bc = (BigChar) pool.get("" + charname);
		// 백지연 : char 타입을 String으로 변환하기 위해 ""와 더했다.
		// 백지연 : getKey는 항상 오브젝트가 리턴되므로 형변환을 해줘야 한다.
		if (bc == null) { // 생성된 BigChar 가 없다면...
			bc = new BigChar(charname); // 여기에서 BigChar의 인스턴스를 생성
			pool.put("" + charname, bc); // pool에 추가한다.
		}
		// 생성된 BigChar 가 있다면, 이것을 반환한다.
		return bc;
	}
}









