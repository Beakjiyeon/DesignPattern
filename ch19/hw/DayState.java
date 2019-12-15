package ch19.hw;

// 주간의 상태를 나타내는 클래스
public class DayState implements State {
	// 하나의 상태만 필요하므로, Singleton 패턴을 사용함
	private static DayState singleton = new DayState();

	private DayState() { // 생성자는 private
	}

	public static State getInstance() { // 유일한 하나의 인스턴스를 얻는다.
		return singleton;
	}

	// 시각을 설정하는 메소드
	public void doClock(Context context, int hour) { 
		// 백지연 : 인자에서 제공된 시간이 야간이라면,
		if(hour<9||(hour>=24)||(hour>=17&&hour<20)) {
			context.changeState(NightState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 점심시간이라면,
		if(hour>=12&&hour<13) {
			context.changeState(NoonState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 야식시간이라면,
		if(hour>=20&&hour<24) {
			context.changeState(NightMealState.getInstance());
		}
		
	}

// “주간 상태”에서 하는 일을 표현하는 메소드

	// 금고 사용을 나타내는 메소드
	public void doUse(Context context) { 
		context.recordLog("금고사용(주간)"); // 주간에 금고를 사용했음을 기록
	}

	// 비상벨로 경비센터를 호출하는 메소드
	public void doAlarm(Context context) { // 비상벨
		context.callSecurityCenter("비상벨(주간)");
	}

	// 경비센터에 일반통화를 함
	public void doPhone(Context context) { 
		context.callSecurityCenter("일반 통화(주간)");
	}

	public String toString() { // 문자열 표현
		return "[주간]";
	}
	// 백지연 : doCCTV() 오버라이드
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: 해상도 600 dpi로 변경");
	}
}
