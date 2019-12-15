package ch19.hw;

// 야간의 상태를 나타내는 클래스
public class NightState implements State {
	private static NightState singleton = new NightState();

	private NightState() { // 생성자는 private
	}

	public static State getInstance() { // 유일한 하나의 인스턴스를 얻는다.
		return singleton;
	}

	public void doClock(Context context, int hour) { // 시각설정
		// 인자에서 제공된 시각이 주간의 시각이면, 
		
		// 백지연 : 인자에서 제공된 시간이 점심시간이라면,
		if(hour>=12&&hour<13) {
			context.changeState(NoonState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 야식시간이라면,
		if(hour>=20&&hour<24) {
			context.changeState(NightMealState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 주간시간이라면,
		if (((hour>=9&&hour<12)||(hour>=13&&hour<17))) {
			context.changeState(DayState.getInstance());
		}		
	}

	public void doUse(Context context) { // 금고사용
		context.callSecurityCenter("비상:야간의 금고사용");
	}

	public void doAlarm(Context context) { // 비상벨
		context.callSecurityCenter("비상벨(야간)");
	}

	public void doPhone(Context context) { // 일반 통화
		context.recordLog("야간의 통화 녹음");
	}

	public String toString() { // 문자열 표현
		return "[야간]";
	}
	// 백지연 : doCCTV() 오버라이드
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: 해상도 1200 dpi로 변경");
	}	
}
