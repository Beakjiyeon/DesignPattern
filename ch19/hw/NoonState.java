package ch19.hw;
// 백지연 : 점심시간(12:00~12:59) 추가
public class NoonState implements State{

	// 백지연 : 하나의 상태만 필요하므로, Singleton 패턴을 사용함
	// 백지연 : static 변수를 사용하면 클래스가 로드될때 객체가 생성된다.
	private static NoonState singleton = new NoonState();

	private NoonState() { // 생성자는 private
	}
	public static State getInstance() {
		// TODO Auto-generated method stub
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		// 백지연 : 인자에서 제공된 시간이 야간이라면,
		if(hour<9||(hour>=17&&hour<20)) {
			context.changeState(NightState.getInstance());
		}
		
		// 백지연 : 인자에서 제공된 시간이 야식시간이라면,
		if(hour>=20&&hour<=24) {
			context.changeState(NightMealState.getInstance());
		}
		// 백지연 : 인자에서 제공된 시간이 주간시간이라면,
		if (((hour>=9&&hour<12)||(hour>=13&&hour<17))) {
			context.changeState(DayState.getInstance());
		}
	}

	// 금고 사용을 나타내는 메소드
	// 백지연 : 금고를 사용하면 경비센터에 비상사태가 통보
	public void doUse(Context context) { 
		// 백지연 : 점심시간에 금고사용 통보
		context.callSecurityCenter("비상:점심시간의 금고사용");
	}

	// 백지연 : 비상벨을 사용하면 경비센터에 비상벨이 통보
	public void doAlarm(Context context) { // 비상벨
		context.callSecurityCenter("비상벨(점심시간)");
	}

	// 백지연 : 전화를 사용하면 경비센터의 자동응답기가 호출
	public void doPhone(Context context) { 
		context.recordLog("일반 통화(점심시간)");
	}

	public String toString() { // 문자열 표현
		return "[점심시간]";
	}

	// 백지연 : doCCTV() 오버라이드
	@Override
	public void doCCTV(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("CCTV: 해상도 300 dpi로 변경");
	}
	

}
