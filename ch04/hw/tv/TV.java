package ch04.hw.tv;

import ch04.hw.framework.*;

public class TV extends Product{
	private String modelNo; // 백지연 : 모델 번호 속성 추가
	
	// 백지연 : 모델 번호를 속성에 저장하는 메소드 : 생성자
	public TV(String modelNo) {
		this.modelNo=modelNo;
	}
	// 백지연 : 모델 번호 ??? 인 tv를 사용한다는 메세지를 출력하는 메소드
	public void use() {
		System.out.println("모델번호 "+modelNo+"인 TV를 사용합니다.");
	}
	// 백지연 : 자신의 모델 번호를 반환하는 메소드
	public String getModelNo() {
		return modelNo;
	}

}
