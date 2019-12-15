package ch19.hw;

// 금고의 상태를 나타냄
public interface State {
	// 각 메소드의 형식 인자는 Context
	// Context 클래스: 상태를 관리하거나 실제 경비센터를 호출하는 일을 하는 클래스
	
	public abstract void doClock(Context context, int hour); // 시각 설정

	public abstract void doUse(Context context); // 금고사용

	public abstract void doAlarm(Context context); // 비상벨

	public abstract void doPhone(Context context); // 일반통화
	
	// 백지연 : cctv 장치 추가하기
	public abstract void doCCTV(Context context);
}
