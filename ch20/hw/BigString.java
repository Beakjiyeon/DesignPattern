package ch20.hw;

// BigChar들을 모은 ‘큰 문자열’ 클래스
public class BigString {
	// "큰 문자"의 배열
	private BigChar[] bigchars;

	// 생성자
	// 입력 인자인 문자열에 해당하는 "큰 문자열"을 만든다. 
	public BigString(String string) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();

		// 필드 bigchars 배열의 각 원소는 
		// BigCharFactory로부터 BigChar를 얻어서 참조한다.
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
		
		// 설명: 
		// BigCharFactory은, 
		// 이미 생성된 BigChar인 경우에는 
		// 기존의 BigChar 인스턴스를 반환하므로, 
		// bigchars 배열의 각 원소는 같은 문자에 대해서는 BigChar 객체를 공유한다.
		
		// (참고) 매번 새로운 인스턴스를 생성하는 경우
/*
		for (int i = 0; i < bigchars.length; i++) {
	        bigchars[i] = new BigChar(string.charAt(i));
	    }
*/

	}

	// 표시
	public void print() {
		for (int i = 0; i < bigchars.length; i++) {
			bigchars[i].print();
		}
	}
}
