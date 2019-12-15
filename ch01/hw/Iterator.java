package ch01.hw;

// 모든 Iterator가 가져야 할 메소드를 선언한 인터페이스
public interface Iterator {
	// 원소가 더 있는지 검사할 때 사용되는 메소드
    public abstract boolean hasNext(); //그 다음 꺼내올 원소가 있는지 없는지 물어보는 메소드
    public abstract Object next(); // 그 다음 원소를 얻어돌 때 사용되는 메소드 
    				//클래스 중 - 킹 : 최상위 클래스이다. -> 무엇을 꺼내올지 모르기 때문에 Object로 선어
}